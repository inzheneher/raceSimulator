package com.mav.conf;

public class Race {

    private int distance;

    public double getTime(int speed) {
        return (double) getDistance() / speed;
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

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
