package com.compassUol.e_commerce.repositories;

import com.compassUol.e_commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
