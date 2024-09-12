package com.hospital.webapp.repositories;

import com.hospital.webapp.dto.client.ClientDTO;
import com.hospital.webapp.dto.user.UserDTO;
import com.hospital.webapp.dto.user.UserExampleDTO;
import com.hospital.webapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    List<UserExampleDTO> findUserBy();

}
