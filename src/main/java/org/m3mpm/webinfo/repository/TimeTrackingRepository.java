package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.TimeTracking;
import org.springframework.data.repository.CrudRepository;

public interface TimeTrackingRepository extends CrudRepository<TimeTracking,Long> {
}
