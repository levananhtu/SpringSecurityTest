package com.lvat.SpringSecurityTest.repository;

import com.lvat.SpringSecurityTest.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
