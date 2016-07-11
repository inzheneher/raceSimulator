package com.mav.model;

class Motorcycle extends Vehicle {

    private final static int amountWheels = 2;
    private final static int recoveryTime = 15;
    private boolean motorcycleCarriage;

    private String getMotorcycleCarriage() {
        if (motorcycleCarriage) {
            return "with Carrige";
        } else {
            return "wout Carrige";
        }
    }

    public void setMotorcycleCarriage(boolean motorcycleCarriage) {
        this.motorcycleCarriage = motorcycleCarriage;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " motorcycleCarriage=" + getMotorcycleCarriage() +
                "}";
    }

    public double getVehicleStopProbability() {
        if (motorcycleCarriage) return (amountWheels + 1) * getFlatTireProbability();
        else return amountWheels * getFlatTireProbability();
    }

    public double getRecoveryTime() {
        return recoveryTime;
    }
}
