package com.example.mobilele.repository;

import com.example.mobilele.model.entity.UserRole;
import com.example.mobilele.model.entity.emumaration.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findByName(RoleEnum user);
}
