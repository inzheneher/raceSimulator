package com.mav.model;

class Motorcycle extends Vehicle {

    private final static int WHEEL_NUMBER = 2;
    private final static int RECOVERY_TIME = 15;
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
                "name=" + getName() +
                "speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " motorcycleCarriage=" + getMotorcycleCarriage() +
                "}";
    }

    public double getVehicleStopProbability() {
        if (motorcycleCarriage) return (WHEEL_NUMBER + 1) * getFlatTireProbability();
        else return WHEEL_NUMBER * getFlatTireProbability();
    }

    public int getRecoveryTime() {
        return RECOVERY_TIME;
    }
}
