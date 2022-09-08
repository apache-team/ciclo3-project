package com.example.apache.repositories;

import com.example.apache.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleNameRepository extends JpaRepository<RoleName, Long> {
}
