package com.epam.freshnewsrest.repository;

import com.epam.freshnewsrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
