package com.mav.model;

import java.io.IOException;
import java.util.HashSet;
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
    private Set<Vehicle> carsInRace;
    private double distance;


    public Race(List<Vehicle> vehicles, double distance) {
        this.vehiсles = vehicles;
        this.distance = distance;
        Set<Vehicle> carsInRace = new HashSet<Vehicle>(this.vehiсles);
    }

    public boolean isRaceOver() {
        return carsInRace.isEmpty();
    }

    public void calculateNextState() {
        if (Math.random() < vehiсle.getVehicle().get(0).getVehicleStopProbability())
    }

/*    void calculate(int timeStep) {
        try {

            car.setTraveledDistance(configuration.getVehicle().get(0).getSpeed() * timeStep);
            truck.setTraveledDistance(configuration.getVehicle().get(1).getSpeed() * timeStep);
            motorcycle.setTraveledDistance(configuration.getVehicle().get(2).getSpeed() * timeStep);

            if (Math.random() < configuration.getVehicle().get(0).getVehicleStopProbability()) {
                System.out.println(TIRE_CAR_FLAT);
            }
            if (Math.random() < configuration.getVehicle().get(1).getVehicleStopProbability()) {
                System.out.println(TIRE_TRUCK_FLAT);
            }
            if (Math.random() < configuration.getVehicle().get(2).getVehicleStopProbability()) {
                System.out.println(TIRE_MOTORCYCLE_FLAT);
            }

            System.out.println(CAR_TRAVELED_DISTANCE + car.getTraveledDistance());
            System.out.println(TRUCK_TRAVELED_DISTANCE + truck.getTraveledDistance());
            System.out.println(MOTORCYCLE_TRAVELED_DISTANCE + motorcycle.getTraveledDistance());

            Thread.sleep(100);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }*/
}
