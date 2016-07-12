package com.mav.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class Configuration {

    private double distance;
    private List<Vehicle> vehicles = new ArrayList<>();

    Configuration() throws IOException {

        InputStream resourceAsStream = Race.class.getResourceAsStream("/config.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(resourceAsStream);
        vehicles.add(mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
        vehicles.add(mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
        vehicles.add(mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));

    }

    List<Vehicle> getVehicle() throws IOException {
        return vehicles;
    }

    public double getDistance() {
        return distance;
    }
}
