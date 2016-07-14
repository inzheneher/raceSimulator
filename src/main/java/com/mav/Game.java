package com.mav;

import com.mav.model.Configuration;

import java.util.Scanner;

class Game {

    private static final String START_MESSAGE = "To start Race type \"start\", to exit Race type \"exit\".";
    private static final String REPEAT_MESSAGE = "Wanna play more? Type \"start\"  or \"exit\".";
    private static final String WRONG_INPUT_MESSAGE = "Type \"start\"  or \"exit\".";


    private static Scanner sc = new Scanner(System.in);

    private final Configuration config;
    private final Race race;
    private final Reporter reporter;
    private boolean gameCondition = true;


    Game(Configuration config, Race race, Reporter reporter) {
        this.config = config;
        this.race = race;
        this.reporter = reporter;
    }

    void run() {

        int i = 0;
        System.out.println(START_MESSAGE);

        while (gameCondition) {

            String gameStartCondition = sc.nextLine();

            switch (gameStartCondition) {

                case "start":
                    reporter.printVehiclesList();
                    System.out.println();
                    runRace();
                    reporter.printRaceResults();
                    System.out.println(REPEAT_MESSAGE);
                    config.resetVehicles();
                    break;

                case "exit":
                    gameCondition = false;
                    break;

                default:
                    System.out.println(WRONG_INPUT_MESSAGE);
                    break;
            }
        }
    }

    private void runRace() {
        while (!race.isOver()) {
            race.calculateNextState();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread is interrupted. Game over.");
            }
        }
    }
}
