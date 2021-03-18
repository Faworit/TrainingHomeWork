package com.epam.ryabtsev.repository;

import com.epam.ryabtsev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiroty extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
