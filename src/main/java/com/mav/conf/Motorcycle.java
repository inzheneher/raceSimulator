package com.mav.conf;

public class Motorcycle extends Vehicle {

    private boolean motorcycleCarriage;
    private final static int amountWheels = 2;
    private final static int recoveryTime = 15;

    public String getMotorcycleCarriage() {
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
    public String toString(){
        return "Motorcycle{" +
                "speed=" + getSpeed() +
                " flatTireProbability=" + getFlatTireProbability() +
                " motorcycleCarriage=" + getMotorcycleCarriage() +
                "}";
    }

    public double getVehicleStopProbability() {
        if(motorcycleCarriage){
            return (amountWheels + 1) * getFlatTireProbability();
        }
        else {
            return amountWheels * getFlatTireProbability();
        }
    }

    public double getRecoveryTime() {
        return recoveryTime;
    }
}
