package com.concurrentdesignsystem;

import java.util.List;

public class Step {
    private int stepId;
    private List<Node> nodes;
    private List<ElementSolid> elements;

    public Step(int stepId, List<Node> nodes, List<ElementSolid> elements) {
        this.stepId = stepId;
        this.nodes = nodes;
        this.elements = elements;
    }

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<ElementSolid> getElements() {
        return elements;
    }

    public void setElements(List<ElementSolid> elements) {
        this.elements = elements;
    }
}
