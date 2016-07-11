package com.mav.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Configuration {

    List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicle() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream resourceAsStream = Game.class.getResourceAsStream("/config.json");
        JsonNode jsonNode = mapper.readTree(resourceAsStream);

        vehicles.add((Car) mapper.readValue(jsonNode.get(0).toString(), Vehicle.class));
        vehicles.add((Truck) mapper.readValue(jsonNode.get(1).toString(), Vehicle.class));
        vehicles.add((Motorcycle) mapper.readValue(jsonNode.get(2).toString(), Vehicle.class));
//        vehicles.add((Race) mapper.readValue(jsonNode.get(3).toString(), Race.class));

        return vehicles;
    }
}
