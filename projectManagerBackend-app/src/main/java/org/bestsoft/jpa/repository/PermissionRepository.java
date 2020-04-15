package org.bestsoft.jpa.repository;

import org.bestsoft.jpa.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
