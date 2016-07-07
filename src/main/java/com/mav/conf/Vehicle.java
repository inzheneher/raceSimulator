package com.mav.conf;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck"),
        @JsonSubTypes.Type(value = Motorcycle.class, name = "Motorcycle")
})
public abstract class Vehicle {
    private int speed;
    private int traveledDistance;
    private double flatTireProbability;
    private double vehicleStopProbability;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getFlatTireProbability() {
        return flatTireProbability;
    }

    public void setFlatTireProbability(double flatTireProbability) {
        this.flatTireProbability = flatTireProbability;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public abstract double getVehicleStopProbability();
}