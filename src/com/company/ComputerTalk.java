package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ComputerTalk {
    public static int playerNumber;
    public static int spyNumber;
    Scanner sc = new Scanner(System.in);

    public void welcomeText() {
        clearConsole();
        System.out.println();
        System.out.println("***Welcome to SpyGame***");
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("Here's a list things you can do:");
        System.out.println();
        System.err.println("*PLAY* ");
        System.err.println("*LOCATIONS* ");
        System.err.println("*RULES* ");

    }

    public void menuScanner() {

        String whatToDo = sc.nextLine();
        switch (whatToDo.toUpperCase(Locale.ROOT)) {
            case "PLAY" -> playMenu();
            case "LOCATIONS" -> System.out.println("chuj");
            case "RULES" -> System.out.println("pizda");

            default -> {
                System.out.println("Enter correct value");
                menuScanner();
            }
        }
    }
    public void clearConsole(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void playMenu() {
        askForNumberOfPlayers();
        askForNumberOfSpies();
        gameImplementation();

    }

    public int askForNumberOfPlayers() {
        Scanner playMenuScanner = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        try {
            playerNumber = playMenuScanner.nextInt();
            return playerNumber;
        } catch (Exception e) {
            System.out.println("Enter correct number do chuja!");
            return askForNumberOfPlayers();
        }
    }
    public int askForNumberOfSpies(){
        Scanner playMenuScanner = new Scanner(System.in);
        System.out.println("Enter number of spies: ");
        try {

            spyNumber = playMenuScanner.nextInt();
            if(spyNumber >= playerNumber) {
                System.out.println("xD? what are you kurwa doing?");
                askForNumberOfSpies();
            }
            else {
                return spyNumber;
            }
        }
        catch (Exception e) {
            System.out.println("Enter correct number do chuja!");
            return askForNumberOfSpies();
        }
        return spyNumber;
    }
    public void gameImplementation(){
        clearConsole();
        RolesArray rolesArray = new RolesArray();
        rolesArray.creatingArrayOfPlayer();
                try {
            roomRevealLoop();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void roomRevealLoop() throws IOException {
        RoomList roomList = new RoomList();
        roomList.implementFirstList();

        Random random = new Random();
        int randomInt = random.nextInt(playerNumber);

        Scanner scanner = new Scanner(System.in);
        int playerIndex = 1;


        for(int i = 0; i < playerNumber; i++){
            System.out.println("Player " + playerIndex);
            if(RolesArray.rolesArray[i] == 1){
                System.out.println("Type *SHOW* to reveal place");
                String showScanner = scanner.nextLine();
                switch (showScanner.toUpperCase(Locale.ROOT)){
                    case "SHOW" -> {
                        System.out.println();
                        System.out.println(roomList.mainList.get(randomInt));
                        System.out.println();
                    }

                    default -> {
                        System.out.println("Enter correct value");
                        System.exit(1);
                    }
                }
            }
            else {
                System.out.println("Type *SHOW* to reveal place");
                String showScanner = scanner.nextLine();
                switch (showScanner.toUpperCase(Locale.ROOT)){
                    case "SHOW" -> {
                        System.out.println();
                        System.out.println("*YOU ARE A SPY*");
                        System.out.println();
                    }

                    default -> {
                        System.out.println("Enter correct value");
                        System.exit(1);
                    }
                }
            }
            System.out.println("Type *NEXT* to hide your data");
            String showScanner = scanner.nextLine();
            switch (showScanner.toUpperCase(Locale.ROOT)){
                case "NEXT" -> clearConsole();
                default -> {
                    System.out.println("Enter correct value");
                    System.exit(1);
                }
            }

            playerIndex++;
        }

    }



}



