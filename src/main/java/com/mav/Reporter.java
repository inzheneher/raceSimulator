package com.mav;

import com.mav.model.Configuration;
import com.mav.model.Vehicle;

import java.util.List;

class Reporter implements RaceListener {

    private final List<Vehicle> vehiсles;
    private final List<Vehicle> finishedVehicles;
    private final int raceDistance;

    Reporter(Configuration configuration, Race race) {

        vehiсles = configuration.getVehicles();
        finishedVehicles = race.getVehiclesFinishedRace();
        raceDistance = configuration.getDistance();
    }

    void printVehiclesList() {
        System.out.println("List of vehicles participating in the race:");
        for (Vehicle vehicle : vehiсles) {
            System.out.println(vehicle);
        }
    }

    void printRaceResults() {
        System.out.println("Table of championship:");
        for (Vehicle vehicle : finishedVehicles) {
            System.out.println(vehicle.getName());
        }
    }

    private void printRaceProgress() {
        for (Vehicle vehicle : vehiсles) {
            if (vehicle.isBroken()) {
                System.out.println(vehicle.getName() + " is broken");
            } else if (vehicle.getTraveledDistance() == raceDistance) {
                System.out.println(vehicle.getName() + " has finished the race");
            } else if (vehicle.getTraveledDistance() < raceDistance){
                System.out.println(vehicle.getName() + " traveled distance is " + vehicle.getTraveledDistance());
            } else {
                System.out.println(vehicle.getName() + " traveled distance is " + raceDistance);
            }
        }
    }

    @Override
    public void nextTimeQuantumPassed() {
        printRaceProgress();
    }
}
