package com.java.techie.securityjwtexample.repository;

import com.java.techie.securityjwtexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
