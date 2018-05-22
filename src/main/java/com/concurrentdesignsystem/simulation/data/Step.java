package com.concurrentdesignsystem.simulation.data;

import lombok.Data;

import java.util.List;

@Data
public class Step {
    private int stepId;
    private List<Node> nodes;
    private List<ElementSolid> elements;
}
