package com.mav;
/**
 * Main is an entry point for the program.
 * Also it's responsible for creation of
 * main program objects and for dependency injection.
 */

import com.mav.model.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        Race race = new Race(config);
        Reporter reporter = new Reporter(config, race);
        race.setRaceListener(reporter);
        new Game(config, race, reporter).run();
    }
}
