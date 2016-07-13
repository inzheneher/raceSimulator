package com.mav;

import com.mav.model.Configuration;
import com.mav.model.Game;
import com.mav.model.Race;

public class Main {

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Race race = new Race(configuration.getVehicles(), configuration.getDistance());
        Game.game();
    }
}