package com.mav.model;

import java.util.*;

public class Race {

    private static final String TIRE_CAR_FLAT = "Car tire is flat. Need repair.";
    private static final String TIRE_TRUCK_FLAT = "Truck tire is flat. Need repair.";
    private static final String TIRE_MOTORCYCLE_FLAT = "Motorcycle tire is flat. Need repair.";
    private static final String CAR_TRAVELED_DISTANCE = "Car traveled: ";
    private static final String TRUCK_TRAVELED_DISTANCE = "Truck traveled: ";
    private static final String MOTORCYCLE_TRAVELED_DISTANCE = "Motorcycle traveled: ";

    private final List<Vehicle> vehiсles;
    private final List<Vehicle> vehiclesFinishedRace;
    private final Set<Vehicle> vehiclesInRace;
    private final double raceDistance;

    private RaceListener raceListener;


    public Race(Configuration configuration) {
        vehiсles = configuration.getVehicles();
        raceDistance = configuration.getDistance();
        vehiclesInRace = new HashSet<>(this.vehiсles);
        vehiclesFinishedRace = new ArrayList<>();
    }

    public boolean isRaceOver() {
        return vehiclesInRace.isEmpty();
    }

    public List<Vehicle> getVehiclesFinishedRace() {
        return vehiclesFinishedRace;
    }

    public void calculateNextState() {
        Iterator<Vehicle> vehicleIterator = vehiclesInRace.iterator();
        while(vehicleIterator.hasNext()){

            Vehicle vehicle = vehicleIterator.next();

            if (vehicle.isBroken()) {
                vehicle.decrementTimeToRecover();
            }
            else if (Math.random() < vehicle.getVehicleStopProbability()) {
                vehicle.flatTire();
            }
            else if (vehicle.getTraveledDistance() == raceDistance) {
                vehiclesFinishedRace.add(vehicle);
                vehicleIterator.remove();
            }
            else {
                vehicle.travel();
            }
        }
        if(raceListener  != null) {
            raceListener.nextTimeQuantumPassed();
        }
    }

    public void setRaceListener(RaceListener raceListener) {
        this.raceListener = raceListener;
    }
}
