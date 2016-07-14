package com.mav.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle")
})
public abstract class Vehicle {
    private int traveledDistance;
    private int timeToRecover;
    private int speed;
    private double flatTireProbability;
    private static final int TIME_QUANTUM = 1;
    private String name;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    double getFlatTireProbability() {
        return flatTireProbability;
    }

    public void setFlatTireProbability(double flatTireProbability) {
        this.flatTireProbability = flatTireProbability;
    }

    public int getTraveledDistance() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void reset() {
        traveledDistance = 0;
        timeToRecover = 0;
    }

    public abstract double getVehicleStopProbability();

    protected abstract int getRecoveryTime();
}