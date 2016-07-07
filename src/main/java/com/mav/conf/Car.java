package com.mav.conf;

public class Car extends Vehicle {

    private int numberOfPeople;
    private final static int amountWheels = 4;

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString(){
        return "Car{" +
                "speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " numberOfPeople=" + getNumberOfPeople() +
                "}";
    }

    public double getVehicleStopProbability() {
        return 0;
    }
}