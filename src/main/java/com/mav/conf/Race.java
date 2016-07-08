package com.mav.conf;

public class Race extends Vehicle{

    public Race(){};

    public double getTime(int speed){
        return (double) getDistance()/speed;
    }

    public double getVehicleStopProbability() {
        return 0;
    }

    public double getRecoveryTime() {
        return 0;
    }

    public int getDistance() {
        return distance;
    }
}
