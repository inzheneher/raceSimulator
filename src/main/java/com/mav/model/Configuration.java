package com.mav.model;

/**
 * This class reas data from configuration files,
 * config.json - for vehicles parameters,
 * raceConfig.txt - for distance length.
 * Also here is the method is used for reset race after finish.
 */

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        } catch (IOException e) {
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
