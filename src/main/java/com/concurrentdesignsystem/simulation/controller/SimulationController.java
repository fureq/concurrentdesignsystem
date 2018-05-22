package com.concurrentdesignsystem.simulation.controller;

import com.concurrentdesignsystem.simulation.data.ElementSolid;
import com.concurrentdesignsystem.simulation.data.Node;
import com.concurrentdesignsystem.simulation.service.SimulationService;
import com.concurrentdesignsystem.simulation.data.Step;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulation")
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/step/{stepId}")
    public Step getSimulationStep(@PathVariable("stepId") int stepId) {
        return simulationService.getSimulationStep(stepId);
    }

    @GetMapping("/step/{stepId}/node/{nodeId}")
    public Node getSimulationNodeFromStep(
            @PathVariable("stepId") int stepId,
            @PathVariable("nodeId") int nodeId
    ) {
        return simulationService.getSimulationNodeFromStep(nodeId, stepId);
    }

    @GetMapping("/step/{stepId}/element/{elementId}")
    public ElementSolid getSimulationElementFromStep(
            @PathVariable("stepId") int stepId,
            @PathVariable("elementId") int elementId
    ) {
        return simulationService.getSimulationElementFromStep(elementId, stepId);
    }
}
