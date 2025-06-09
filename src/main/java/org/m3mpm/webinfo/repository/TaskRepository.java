package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {
}
