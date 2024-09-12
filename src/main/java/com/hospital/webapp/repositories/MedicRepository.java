package com.hospital.webapp.repositories;

import com.hospital.webapp.entities.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, Long> {

    @Query(value = "SELECT u.name, u.surname, u.email, m.mci, " +
            "GROUP_CONCAT(s.name SEPARATOR ', ') AS specialties " +
            "FROM medic_specialization ms " +
            "JOIN medic m ON ms.medic_id = m.id " +
            "JOIN user u ON m.user_id = u.id " +
            "JOIN specialties s ON ms.specialization_id = s.id " +
            "WHERE m.mci = :mci " +
            "GROUP BY u.name, u.surname, u.email, m.mci",
        nativeQuery = true)
    List<Object[]> findUserAndMedicDetailsByMci(@Param("mci") String mci);

}
