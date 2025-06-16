package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.entity.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<CheckEntity, Long> {
}
