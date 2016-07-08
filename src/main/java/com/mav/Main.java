package com.mav;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.conf.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean gameCondition = true;
        String anim= "|/-\\";

        try {

            Scanner sc = new Scanner(System.in);

            while (gameCondition){

                String gameStartCondition = sc.nextLine();

                if (gameStartCondition.equals("start")){

                    ObjectMapper mapper = new ObjectMapper();
                    InputStream resourceAsStream = Main.class.getResourceAsStream("/test.json");
                    JsonNode jsonNode = mapper.readTree(resourceAsStream);

                    Car car = (Car) mapper.readValue(jsonNode.get(0).toString(), Vehicle.class);
                    Truck truck = (Truck) mapper.readValue(jsonNode.get(1).toString(), Vehicle.class);
                    Motorcycle motorcycle = (Motorcycle) mapper.readValue(jsonNode.get(2).toString(), Vehicle.class);
                    Race race = (Race) mapper.readValue(jsonNode.get(3).toString(), Vehicle.class);

                    System.out.println(car.getVehicleStopProbability());
                    System.out.println(truck.getVehicleStopProbability());
                    System.out.println(motorcycle.getVehicleStopProbability());

                    System.out.println(mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));

                    System.out.println();

/*                    for (int x = 0 ; x <= 100 ; x++){
                        String data = "\r" + anim.charAt(x % anim.length())  + " " + x ;
                        System.out.write(data.getBytes());
                        Thread.sleep(100);
                    }*/

                    System.out.println(); System.out.println();

                    System.out.println(race.getTime(car.getSpeed()));
                    System.out.println(race.getTime(truck.getSpeed()));
                    System.out.println(race.getTime(motorcycle.getSpeed()));

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