package com.mav.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Race {

    private static final String TIRE_CAR_FLAT = "Car tire is flat. Need repair.";
    private static final String TIRE_TRUCK_FLAT = "Truck tire is flat. Need repair.";
    private static final String TIRE_MOTORCYCLE_FLAT = "Motorcycle tire is flat. Need repair.";
    private static final String CAR_TRAVELED_DISTANCE = "Car traveled: ";
    private static final String TRUCK_TRAVELED_DISTANCE = "Truck traveled: ";
    private static final String MOTORCYCLE_TRAVELED_DISTANCE = "Motorcycle traveled: ";

    private List<Vehicle> vehiсles;
    private Set<Vehicle> vehiclesInRace;
    private double raceDistance;


    public Race(List<Vehicle> vehicles, double raceDistance) {
        this.vehiсles = vehicles;
        this.raceDistance = raceDistance;
        Set<Vehicle> vehiclesInRace = new HashSet<Vehicle>(this.vehiсles);
    }

    public boolean isRaceOver() {
        return vehiclesInRace.isEmpty();
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
                vehicleIterator.remove();
            }
            else {
                vehicle.travel();
            }
        }
    }
}
