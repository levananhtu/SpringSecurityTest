package com.lvat.SpringSecurityTest.repository;

import com.lvat.SpringSecurityTest.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
