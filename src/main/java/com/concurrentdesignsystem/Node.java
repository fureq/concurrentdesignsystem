package com.concurrentdesignsystem;

public class Node {
    private int nodeId;
    private double x;
    private double y;

    private double z;
    private double temperature;

    public Node(int nodeId, double x, double y, double z, double temperature) {
        this.nodeId = nodeId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.temperature = temperature;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
