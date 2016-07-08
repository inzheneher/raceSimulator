package com.mav;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.conf.Car;
import com.mav.conf.Motorcycle;
import com.mav.conf.Truck;
import com.mav.conf.Vehicle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean gameCondition = true;

        try {

            Scanner sc = new Scanner(System.in);

            while (gameCondition){

                String gameStartCondition = sc.nextLine();

                if (gameStartCondition.equals("start")){

                    ObjectMapper mapper = new ObjectMapper();
                    InputStream resourceAsStream = Main.class.getResourceAsStream("/test.json");
                    JsonNode jsonNode = mapper.readTree(resourceAsStream);

                    Motorcycle motorcycle = (Motorcycle) mapper.readValue(jsonNode.get(2).toString(), Vehicle.class);
                    Car car = (Car) mapper.readValue(jsonNode.get(0).toString(), Vehicle.class);
                    Truck truck = (Truck) mapper.readValue(jsonNode.get(1).toString(), Vehicle.class);

                    System.out.println(motorcycle.getVehicleStopProbability());
                    System.out.println(car.getVehicleStopProbability());
                    System.out.println(truck.getVehicleStopProbability());

                    System.out.println(mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
                    System.out.println(mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));

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