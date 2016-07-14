package com.mav.model;

import java.util.List;

public class Reporter implements RaceListener {

    private final List<Vehicle> vehiсles;
    private final List<Vehicle> finishedVehicles;
    private final int raceDistance;

    public Reporter(Configuration configuration, Race race) {

        vehiсles = configuration.getVehicles();
        finishedVehicles = race.getVehiclesFinishedRace();
        raceDistance = configuration.getDistance();

    }

    public void printVehiclesList(){
        System.out.println("List of vehicles participating in the race:");
        for (Vehicle vehicle: vehiсles) {
            System.out.println(vehicle);
        }
    }

    public void printRaceResults() {
        System.out.println("Table of championship:");
        for(Vehicle vehicle : finishedVehicles) {
            System.out.println(vehicle.getName());
        }

    }

    private void printRaceProgress() {
        for(Vehicle vehicle : vehiсles) {
            if(vehicle.isBroken()){
                System.out.println(vehicle.getName() + " is broken");
            } else if(vehicle.getTraveledDistance() == raceDistance) {
                System.out.println(vehicle.getName() + " has finished the race");
            } else {
                System.out.println(vehicle.getName() + " traveled distance is "  + vehicle.getTraveledDistance());
            }

        }
    }


    @Override
    public void nextTimeQuantumPassed() {
        printRaceProgress();
    }
}
