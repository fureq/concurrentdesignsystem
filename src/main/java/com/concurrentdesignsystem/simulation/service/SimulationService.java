package com.concurrentdesignsystem.simulation.service;

import com.concurrentdesignsystem.simulation.data.ElementSolid;
import com.concurrentdesignsystem.simulation.data.Node;
import com.concurrentdesignsystem.simulation.repository.StepRepository;
import com.concurrentdesignsystem.simulation.data.Step;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private final StepRepository stepRepository;

    public SimulationService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public Step getSimulationStep(int stepId) {
        return stepRepository.findByStepId(stepId).orElseThrow(RuntimeException::new);
    }

    public Node getSimulationNodeFromStep(int nodeId, int stepId) {
        return stepRepository.findByStepId(stepId)
                .map(Step::getNodes)
                .map(list -> list.get(nodeId - 1))
                .orElseThrow(RuntimeException::new);
    }

    public ElementSolid getSimulationElementFromStep(int elementId, int stepId) {
        return stepRepository.findByStepId(stepId)
                .map(Step::getElements)
                .map(list -> list.get(elementId - 1))
                .orElseThrow(RuntimeException::new);
    }
}
