package com.concurrentdesignsystem.simulation.data;

import lombok.Data;

@Data
public class Node {
    private int nodeId;
    private double x;
    private double y;

    private double z;
    private double temperature;
}
