package com.mav;

import com.mav.model.Configuration;
import com.mav.model.Game;
import com.mav.model.Race;
import com.mav.model.Reporter;

public class Main {

    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        Race race = new Race(configuration);
        Reporter reporter = new Reporter(configuration, race);
        Game.game();
    }
}