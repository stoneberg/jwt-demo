package com.stone.rest.play.user.repository;

import com.stone.rest.play.user.domain.Role;
import com.stone.rest.play.user.domain.RoleCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleCode name);
}

