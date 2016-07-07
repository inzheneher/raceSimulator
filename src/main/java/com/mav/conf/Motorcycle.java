package com.mav.conf;

public class Motorcycle extends Vehicle {

    private boolean motorcycleCarriage;

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
        return 0;
    }
}
