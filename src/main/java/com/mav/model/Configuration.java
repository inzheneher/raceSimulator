package com.mav.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.Race;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Configuration {

    private List<Vehicle> vehicles = new ArrayList<>();

    private int distance;

    public Configuration() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream resourceAsStream = Configuration.class.getResourceAsStream("/config.json");
            InputStream race = Configuration.class.getResourceAsStream("/raceConfig.txt");
            JsonNode jsonNode = mapper.readTree(resourceAsStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(race));
            distance = Integer.parseInt(reader.readLine());
            Iterator<JsonNode> elements = jsonNode.elements();
            while (elements.hasNext()) {
                vehicles.add(mapper.readValue(elements.next().toString(), Vehicle.class));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getDistance() {
        return distance;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void resetVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.reset();
        }
    }
}
