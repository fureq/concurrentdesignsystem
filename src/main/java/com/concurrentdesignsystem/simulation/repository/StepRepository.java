package com.concurrentdesignsystem.simulation.repository;

import com.concurrentdesignsystem.simulation.data.Step;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StepRepository extends MongoRepository<Step, String> {
    Optional<Step> findByStepId(int stepId);
}
