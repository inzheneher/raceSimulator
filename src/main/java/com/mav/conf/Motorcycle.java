package com.mav.conf;

public class Motorcycle extends Vehicle {

    private boolean motorcycleCarriage;
    private final static int amountWheels = 2;
    private final static int recoveryTime = 15;

    public boolean getMotorcycleCarriage() {
        return motorcycleCarriage;
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
        if(getMotorcycleCarriage()){
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
