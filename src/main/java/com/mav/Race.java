package com.mav;

/**
 * This class is a game engine.
 */

import com.mav.model.Configuration;
import com.mav.model.Vehicle;

import java.util.*;

class Race {

    private final List<Vehicle> vehiclesFinishedRace;
    private Set<Vehicle> vehiclesInRace;
    private double raceDistance;

    private RaceListener raceListener;


    Race(Configuration configuration) {
        raceDistance = configuration.getDistance();
        vehiclesInRace = new HashSet<>(configuration.getVehicles());
        vehiclesFinishedRace = new ArrayList<>();
    }

    boolean isOver() {
        return vehiclesInRace.isEmpty();
    }

    List<Vehicle> getVehiclesFinishedRace() {
        return vehiclesFinishedRace;
    }

    void calculateNextState() {
        Iterator<Vehicle> vehicleIterator = vehiclesInRace.iterator();
        while (vehicleIterator.hasNext()) {

            Vehicle vehicle = vehicleIterator.next();

            if (vehicle.isBroken()) {
                vehicle.decrementTimeToRecover();
            } else if (Math.random() < vehicle.getVehicleStopProbability()) {
                vehicle.flatTire();
            } else if (vehicle.getTraveledDistance() >= raceDistance) {
                vehiclesFinishedRace.add(vehicle);
                vehicleIterator.remove();
            } else {
                vehicle.travel();
            }
        }
        if (raceListener != null) {
            raceListener.nextTimeQuantumPassed();
        }
    }

    void setRaceListener(RaceListener raceListener) {
        this.raceListener = raceListener;
    }

    void resetRace() {
        vehiclesInRace.addAll(vehiclesFinishedRace);
        vehiclesFinishedRace.clear();
    }
}
