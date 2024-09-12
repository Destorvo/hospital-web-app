package com.hospital.webapp.controllers;

import com.hospital.webapp.dto.medic.MedicCreateDTO;
import com.hospital.webapp.dto.medic.MedicDTO;
import com.hospital.webapp.dto.medic.MedicUpdateDTO;
import com.hospital.webapp.entities.Medic;
import com.hospital.webapp.entities.User;
import com.hospital.webapp.entities.WorkShift;
import com.hospital.webapp.repositories.WorkShiftRepository;
import com.hospital.webapp.service.MedicService;
import com.hospital.webapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medics")
public class MedicController {

    private final MedicService medicService;
    private final UserService userService;
    private final WorkShiftRepository workShiftRepository;

    public MedicController(MedicService medicService, UserService userService, WorkShiftRepository workShiftRepository) {
        this.medicService = medicService;
        this.userService = userService;
        this.workShiftRepository = workShiftRepository;
    }

    @GetMapping
    public List<Medic> getMedics() {
        return medicService.getMedics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medic> getMedicById(@PathVariable Long id) {
        Optional<Medic> optionalMedicDTO = medicService.getMedicById(id);
        return optionalMedicDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<MedicDTO> searchMedicByCode(@RequestParam("mci") String mci) {
        Optional<MedicDTO> optionalMedicDTO = medicService.getMedicByMedicCode(mci);
        return optionalMedicDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<?> createMedic(@Valid @RequestBody MedicCreateDTO medicCreateDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        User user = userService.getUserById(medicCreateDTO.getUserId()).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();

        Medic newMedic = new Medic();
        newMedic.setMci(medicCreateDTO.getMci());
        newMedic.setUserMedic(user);
        medicService.saveMedic(newMedic);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newMedic.getId())
                .toUri();
        return ResponseEntity.created(location).body(medicCreateDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedic(@PathVariable Long id, @RequestBody MedicUpdateDTO medicUpdateDTO) {
        Optional<Medic> existentMedic = medicService.getMedicById(id);
        if(existentMedic.isEmpty())
            return ResponseEntity.notFound().build();

        WorkShift workShift = workShiftRepository.findById(medicUpdateDTO.getWorkShiftId()).orElse(null);
        if (workShift == null)
            return ResponseEntity.notFound().build();

        Medic medic =existentMedic.get();
        medic.setMci(medicUpdateDTO.getMci());
        medic.setWorkShift(workShift);
        medicService.saveMedic(medic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMedic(@PathVariable Long id) {
        return medicService.getMedicById(id)
                .map(u ->{
                    medicService.deleteMedicById(id);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
