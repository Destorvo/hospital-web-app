package com.hospital.webapp.repositories;

import com.hospital.webapp.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Roles, Byte> {
}
