package com.mav.model;

import java.io.IOException;
import java.util.List;

public class Race {

    private static final String TIRE_CAR_FLAT = "Car tire is flat. Need repair.";
    private static final String TIRE_TRUCK_FLAT = "Truck tire is flat. Need repair.";
    private static final String TIRE_MOTORCYCLE_FLAT = "Motorcycle tire is flat. Need repair.";
    private static final String CAR_TRAVELED_DISTANCE = "Car traveled: ";
    private static final String TRUCK_TRAVELED_DISTANCE = "Truck traveled: ";
    private static final String MOTORCYCLE_TRAVELED_DISTANCE = "Motorcycle traveled: ";
    private Car car = new Car();
    private Truck truck = new Truck();
    private Motorcycle motorcycle = new Motorcycle();
    private Configuration configuration = new Configuration();

    public Race(List<Vehicle> vehicles, double distance) {
    }

    public double getTime(int speed) {
        return (double) getDistance() / speed;
    }

    public double getVehicleStopProbability() {
        return 0;
    }

    public double getRecoveryTime() {
        return 0;
    }

    double getDistance() {
        return distance;
    }


    public void setDistance(int distance) {
        this.distance = distance;
    }

    void calculate(int timeStep) {
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
    }
}
