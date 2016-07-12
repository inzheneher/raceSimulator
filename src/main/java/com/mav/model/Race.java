package com.mav.model;

import java.io.IOException;
import java.util.Scanner;

public class Race {

    private static final String TIRE_CAR_FLAT = "Car tire is flat. Need repair.";
    private static final String TIRE_TRUCK_FLAT = "Truck tire is flat. Need repair.";
    private static final String TIRE_MOTORCYCLE_FLAT = "Motorcycle tire is flat. Need repair.";
    private static final String CAR_TRAVELED_DISTANCE = "Car traveled: ";
    private static final String TRUCK_TRAVELED_DISTANCE = "Truck traveled: ";
    private static final String MOTORCYCLE_TRAVELED_DISTANCE = "Motorcycle traveled: ";
    private static final String START_MESSAGE = "To start Race type \"start\", to exit Race type \"exit\".";
    private static final String REPEAT_MESSAGE = "Wanna play more? Type \"start\"  or \"exit\".";
    private static final String WRONG_INPUT_MESSAGE = "Type \"start\"  or \"exit\".";

    private static Car car = new Car();
    private Truck truck = new Truck();
    private Motorcycle motorcycle = new Motorcycle();
    private Configuration configuration = new Configuration();

    Race() throws IOException {
    }

    public void calculate(int timeStep) {
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

    public static void game() throws IOException {

        boolean gameCondition = true;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        Race gameLogic = new Race();
        Configuration configuration = new Configuration();

        System.out.println(START_MESSAGE);

        while (gameCondition) {

            String gameStartCondition = sc.nextLine();

            switch (gameStartCondition) {

                case "start":

                    System.out.println();

                    while (true) {

                        if(car.getTraveledDistance() > configuration.getDistance()){
                            break;
                        }

                        gameLogic.calculate(i);
                        i++;
                    }

                    System.out.println();

                    System.out.println(REPEAT_MESSAGE);
                    break;

                case "exit":
                    gameCondition = false;
                    break;

                default:
                    System.out.println(WRONG_INPUT_MESSAGE);
                    break;
            }
        }
    }
}
