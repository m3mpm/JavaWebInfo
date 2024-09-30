package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CheckRepository extends JpaRepository<Check,Long> {
}
