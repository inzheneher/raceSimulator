package com.mav;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.conf.Motorcycle;
import com.mav.conf.Vehicle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            Scanner sc = new Scanner(System.in);

            ObjectMapper mapper = new ObjectMapper();
            InputStream resourceAsStream = Main.class.getResourceAsStream("/test.json");
            JsonNode jsonNode = mapper.readTree(resourceAsStream);
            Motorcycle testObj = new Motorcycle();
            testObj.setMotorcycleCarriage(jsonNode.get(2).has("motorcycleCarriage"));
            System.out.println(testObj.getMotorcycleCarriage());
            System.out.println(testObj.getVehicleStopProbability());
            System.out.println(mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
            System.out.println(mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
            System.out.println(mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));
        }
        catch (JsonParseException e) { e.printStackTrace(); }
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}