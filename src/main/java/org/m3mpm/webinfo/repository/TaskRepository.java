package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task,String> {
}
