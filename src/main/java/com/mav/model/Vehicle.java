package com.mav.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle"),
        @JsonSubTypes.Type(value = Race.class, name = "Race")
})
abstract class Vehicle {
    private double traveledDistance;
    private int speed;
    private double flatTireProbability;

    int getSpeed() {
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

    double getTraveledDistance() {
        return traveledDistance;
    }

    void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public abstract double getVehicleStopProbability();

    public abstract double getRecoveryTime();
}