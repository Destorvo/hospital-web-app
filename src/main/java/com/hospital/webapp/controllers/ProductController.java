/*package com.hospital.webapp.controllers;


import com.hospital.webapp.service.MedicineService;
import com.hospital.webapp.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/products")
public class ProductController {

    private MedicineService medicineService;

    public ProductController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/all")
    public String getAllMedicine(Model model) {
        List<String> medicineList = medicineService.getAllMedicine();
        model.addAttribute("products", medicineList);
        return "products";
    }

    @GetMapping("/{id}")
    public String getMedicineById(@PathVariable Long id, Model model) {
        Product medicine = medicineService.getMedicineById(id);
        model.addAttribute("product", medicine);
        return "product";
    }


}
*/