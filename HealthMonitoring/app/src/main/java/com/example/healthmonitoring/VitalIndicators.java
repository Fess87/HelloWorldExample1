package com.example.healthmonitoring;

public class VitalIndicators {

    private double weight;
    private int quanitySteps;

    public VitalIndicators(double weight, int quanitySteps) {
        this.weight = weight;
        this.quanitySteps = quanitySteps;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuanitySteps() {
        return quanitySteps;
    }
}
