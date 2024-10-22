package se.oscar.adventure;

import se.oscar.adventure.model.Creature;
import se.oscar.adventure.model.Monster;
import se.oscar.adventure.model.Player;

import java.util.Scanner;

public class Game {
    private final String NORTH = "north";
    private final String SOUTH = "south";
    private final String EAST = "east";
    private final String WEST = "west";
    private final String TOWN_CENTER = "town_center";
    private final String START = "start";
    private String currentLocation = START;
    private Creature player;
    private Creature monster;
    private boolean run = true;
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        townCentre();
        while (run && player.isAlive()) {
            run = processInput();
        }
    }

    public void stop() { //Force Quit
        run = false;
    }

    public void welcomeMessage() {
        try {
            System.out.println("""
                      *****************************
                      Welcome to the Adventure Game
                      *****************************
                    
                    Instructions:
                    Control the player by typing the action you would like to take
                    Commands include: 'go north' 'go south' 'go east' 'go west' 'go to town' or 'quit'
                    You can only walk to adjacent locations
                    If your health reaches 0 you lose
                    """);
            Thread.sleep(1000);
            System.out.println("Do you want to start the game? (y/n)");
            switch (getUserInput()) {
                case "y" -> {
                    System.out.println("Enter Player Name: ");
                    player = new Player(100, 35, getUserInput());
                    monster = new Monster(60, 15, "Goblin");
                    System.out.println("Starting the game. . .");
                    start();
                }
                case "n" -> System.out.println("Perhaps another time.");
                default -> System.out.println("Invalid input.");
            }
        } catch (Exception _) {
        }
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

    void executeAttack(Creature attacker, Creature defender) {
        attacker.attack(defender);
        System.out.println(attacker.getName() + " attacks " + defender.getName() + " for " + attacker.getDamage());
        if (defender.isAlive()) {
            System.out.println(defender.getName() + " has " + defender.getHealth() + " health left");
        } else {
            System.out.println(defender.getName() + " has died!");
        }
    }

    private void fightOneRound() {
        executeAttack(player, monster);
        if (monster.isAlive()) {
            executeAttack(monster, player);
        }
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

            fightOneRound();

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
