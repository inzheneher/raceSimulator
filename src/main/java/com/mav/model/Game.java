package com.mav.model;

import java.util.Scanner;

public class Game {

    private static final String START_MESSAGE = "To start Race type \"start\", to exit Race type \"exit\".";
    private static final String REPEAT_MESSAGE = "Wanna play more? Type \"start\"  or \"exit\".";
    private static final String WRONG_INPUT_MESSAGE = "Type \"start\"  or \"exit\".";
    private static boolean gameCondition = true;

    private static Scanner sc = new Scanner(System.in);
    private static Race gameLogic = new Race();

    public static void game() {

        System.out.println(START_MESSAGE);

        while (gameCondition) {

            String gameStartCondition = sc.nextLine();

            switch (gameStartCondition) {

                case "start":

                    System.out.println();

                    for (int i = 0; i < 10; i++) {
                        gameLogic.calculate(i);
                    }

                    System.out.println();

                    System.out.println(REPEAT_MESSAGE);
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
}
