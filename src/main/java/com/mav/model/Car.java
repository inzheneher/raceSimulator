package com.mav.model;

class Car extends Vehicle {

    private final static int WHEEL_NUMBER = 4;
    private final static int RECOVERY_TIME = 3;
    private int numberOfPeople;

    private int getNumberOfPeople() {
        return numberOfPeople;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + getName() +
                " speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " numberOfPeople=" + getNumberOfPeople() +
                "}";
    }

    public double getVehicleStopProbability() {
        return WHEEL_NUMBER * getFlatTireProbability();
    }

    public int getRecoveryTime() {
        return RECOVERY_TIME;
    }
}