package com.concurrentdesignsystem.simulation.data;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "StepCollection")
@ToString
public class Step {
    @Id
    public String id;
    private int stepId;
    private List<Node> nodes;
    private List<ElementSolid> elements;
}
