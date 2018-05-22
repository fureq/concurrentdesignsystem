package com.concurrentdesignsystem.simulation.data;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "StepCollection")
public class Step {
    @Id
    private String id;
    private int stepId;
    private List<Node> nodes;
    private List<ElementSolid> elements;
}
