package se.oscar.adventure;

import java.util.Scanner;

public class Game {
    private final String NORTH = "north";
    private final String SOUTH = "south";
    private final String EAST = "east";
    private final String WEST = "west";
    private final String TOWN_CENTER = "town_center";
    private final String START = "start";
    private String currentLocation = START;
    private boolean run = true;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        townCentre();
        while (run) {
            run = processInput();
        }
    }

    public void stop() {
        run = false;
    }

    public void welcomeMessage() {
        try {
            System.out.println("""
                      *****************************
                      Welcome to the Adventure Game
                      *****************************
                    """);
            Thread.sleep(1000);
            System.out.println("Starting Game. . .");
        } catch (Exception _) {
        }
        start();
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    private boolean processInput() {
        String choice = getUserInput().toLowerCase();
        switch (choice) {
            case "go north" -> north();
            case "go south" -> south();
            case "go east" -> east();
            case "go west" -> west();
            case "go to town" -> townCentre();
            case "quit" -> {
                return false;
            }
            default -> System.out.println("Bad input");
        }
        return true;
    }

    private void townCentre() {
        if (!currentLocation.equals(TOWN_CENTER)) {
            System.out.println("You enter a bustling town crowded with merchants and adventurers alike.");
            // Town implement
            currentLocation = TOWN_CENTER;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void north() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going north");
            // Encounter implement
            currentLocation = NORTH;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void south() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going south");
            // Encounter implement
            currentLocation = SOUTH;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void east() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going east");
            // Encounter implement
            currentLocation = EAST;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void west() {
        if (currentLocation.equals(TOWN_CENTER)) {
            System.out.println("Going west");
            // Encounter implement
            currentLocation = WEST;
        } else {
            System.out.println("You cant go there");
        }
        nextMove();
    }

    private void nextMove() {
        System.out.println("What do you want to do next?");
    }
}
