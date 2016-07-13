package com.mav.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mav.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Configuration {

    private List<Vehicle> vehicles = new ArrayList<>();

    private double distance;

    Configuration() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream resourceAsStream = Configuration.class.getResourceAsStream("/config.json");
            InputStream race = Configuration.class.getResourceAsStream("/raceConfig.txt");
            JsonNode jsonNode = mapper.readTree(resourceAsStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(race));
            distance = Double.parseDouble(reader.readLine());
            Iterator<JsonNode> elements = jsonNode.elements();
            while(elements.hasNext()){
                vehicles.add(mapper.readValue(elements.next().toString(), Vehicle.class));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getDistance() {
        return distance;
    }

    List<Vehicle> getVehicle() throws IOException {
        return vehicles;
    }
}
