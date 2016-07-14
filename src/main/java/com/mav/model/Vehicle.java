package com.mav.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle")
})
abstract class Vehicle {
    private double traveledDistance;
    private double timeToRecover;
    private int speed;
    private double flatTireProbability;
    private static final int TIME_QUANTUM = 1;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    double getFlatTireProbability() {
        return flatTireProbability;
    }

    public void setFlatTireProbability(double flatTireProbability) {
        this.flatTireProbability = flatTireProbability;
    }

    double getTraveledDistance() {
        return traveledDistance;
    }

    void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public void flatTire() {
        timeToRecover = getRecoveryTime();
    }

    public void decrementTimeToRecover() {
        timeToRecover--;
    }

    public boolean isBroken() {
        return timeToRecover > 0;
    }

    public void travel() {
        traveledDistance += speed * TIME_QUANTUM;
    }

    public abstract double getVehicleStopProbability();

    protected abstract double getRecoveryTime();
}