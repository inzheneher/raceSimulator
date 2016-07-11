package com.mav.model;

class Car extends Vehicle {

    private final static int amountWheels = 4;
    private final static int recoveryTime = 25;
    private int numberOfPeople;

    private int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " numberOfPeople=" + getNumberOfPeople() +
                "}";
    }

    public double getVehicleStopProbability() {
        return amountWheels * getFlatTireProbability();
    }

    public double getRecoveryTime() {
        return recoveryTime;
    }
}