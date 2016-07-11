package com.mav.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Game {

    public static final String anim = "|/-\\";
    public static final String START_MESSAGE = "To start Race type \"start\", to exit Race type \"exit\".";
    public static final String REPEAT_MESSAGE = "Wanna play more? Type \"start\"  or \"exit\".";
    public static final String WRONG_INPUT_MESSAGE = "Type \"start\"  or \"exit\".";
    public static boolean gameCondition = true;

    public static void game(){

        try {

            System.out.println(START_MESSAGE);

            Scanner sc = new Scanner(System.in);

            while (gameCondition) {

                String gameStartCondition = sc.nextLine();

                if (gameStartCondition.equals("start")) {

                    /*ObjectMapper mapper = new ObjectMapper();
                    InputStream resourceAsStream = Game.class.getResourceAsStream("/config.json");
                    JsonNode jsonNode = mapper.readTree(resourceAsStream);

                    Car car = (Car) mapper.readValue(jsonNode.get(0).toString(), Vehicle.class);
                    Truck truck = (Truck) mapper.readValue(jsonNode.get(1).toString(), Vehicle.class);
                    Motorcycle motorcycle = (Motorcycle) mapper.readValue(jsonNode.get(2).toString(), Vehicle.class);
                    Race race = mapper.readValue(jsonNode.get(3).toString(), Race.class);*/

                    Configuration configuration = new Configuration();

                    for (Vehicle v: configuration.getVehicle()){
                        System.out.println(v);
                    }

                    /*System.out.println(mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));*/

                    System.out.println();

                    for (int x = 0; x <= 100; x++) {
                        String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
                        System.out.write(data.getBytes());
                        Thread.sleep(100);
                    }

                    /*System.out.println();
                    System.out.println();

                    System.out.println("Car race time: " +
                            race.getTime(car.getSpeed()));
                    System.out.println("Truck race time: " +
                            race.getTime(truck.getSpeed()));
                    System.out.println("Motorcycle race time: " +
                            race.getTime(motorcycle.getSpeed()));

                    System.out.println();*/

                    System.out.println(REPEAT_MESSAGE);
                } else if (gameStartCondition.equals("exit")) {
                    gameCondition = false;
                } else {
                    System.out.println(WRONG_INPUT_MESSAGE);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
