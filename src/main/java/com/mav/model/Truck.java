package com.mav.model;

class Truck extends Vehicle {

    private final static int WHEEL_NUMBER = 6;
    private final static int RECOVERY_TIME = 5;
    private int cargoWeight;

    private int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "name=" + getName() +
                " speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " cargoWeight=" + getCargoWeight() +
                "}";
    }

    public double getVehicleStopProbability() {
        return WHEEL_NUMBER * getFlatTireProbability();
    }

    public int getRecoveryTime() {
        return RECOVERY_TIME;
    }
}
