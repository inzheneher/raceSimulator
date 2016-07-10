package com.mav;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.conf.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean gameCondition = true;
        String anim= "|/-\\";

        try {

            System.out.println("To start Race type 'start', to exit Race type 'exit'");

            Scanner sc = new Scanner(System.in);

            while (gameCondition){

                String gameStartCondition = sc.nextLine();

                if (gameStartCondition.equals("start")){

                    ObjectMapper mapper = new ObjectMapper();
                    InputStream resourceAsStream = Main.class.getResourceAsStream("/config.json");
                    JsonNode jsonNode = mapper.readTree(resourceAsStream);

                    Car car = (Car) mapper.readValue(jsonNode.get(0).toString(), Vehicle.class);
                    Truck truck = (Truck) mapper.readValue(jsonNode.get(1).toString(), Vehicle.class);
                    Motorcycle motorcycle = (Motorcycle) mapper.readValue(jsonNode.get(2).toString(), Vehicle.class);
                    Race race = mapper.readValue(jsonNode.get(3).toString(), Race.class);

                    System.out.println(mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));

                    System.out.println();

                    for (int x = 0 ; x <= 100 ; x++){
                        String data = "\r" + anim.charAt(x % anim.length())  + " " + x ;
                        System.out.write(data.getBytes());
                        Thread.sleep(100);
                    }

                    System.out.println(); System.out.println();

                    System.out.println("Car race time: " +
                            race.getTime(car.getSpeed()));
                    System.out.println("Truck race time: " +
                            race.getTime(truck.getSpeed()));
                    System.out.println("Motorcycle race time: " +
                            race.getTime(motorcycle.getSpeed()));

                    System.out.println();

                    System.out.println("Wanna play more? Type 'start'  or 'exit'");
                }
                else if (gameStartCondition.equals("exit")){
                    gameCondition = false;
                }
                else {
                    System.out.println("Type 'start' or 'exit'");
                }
            }
        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}