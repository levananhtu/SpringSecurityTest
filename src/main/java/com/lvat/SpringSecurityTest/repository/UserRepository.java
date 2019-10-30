package com.lvat.SpringSecurityTest.repository;

import com.lvat.SpringSecurityTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    <T> T findByUsername(String username, Class<T> type);
}
