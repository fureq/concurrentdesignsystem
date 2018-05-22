package com.concurrentdesignsystem.simulation.repository;

import com.concurrentdesignsystem.simulation.data.Step;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StepRepository extends MongoRepository<Step, String> {
}
