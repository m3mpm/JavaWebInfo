package org.m3mpm.webinfo.repository;

import org.m3mpm.webinfo.model.Recommendation;
import org.springframework.data.repository.CrudRepository;

public interface RecommendationRepository extends CrudRepository<Recommendation,Long> {
}
