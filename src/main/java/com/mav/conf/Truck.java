package com.mav.conf;

public class Truck extends Vehicle {

    private int cargoWeight;
    private final static int amountWheels = 6;
    private final static int recoveryTime = 35;

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public String toString(){
        return "Truck{" +
                "speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " numberOfPeople=" + getCargoWeight() +
                "}";
    }

    public double getVehicleStopProbability() {
        return amountWheels * getFlatTireProbability();
    }

    public double getRecoveryTime() {
        return recoveryTime;
    }
}
