package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeaCreator {

    Sea baltic;

    SeaCreator(int x, int y) {
        baltic = new Sea(x, y);
        clearUsedPoints();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                baltic.getSea()[i][j] = "=";
            }
        }
    }

    SeaCreator(int x, int y, int numOfRedAircraftCarriers, int numOfRedSubmarines, int numOfRedCruisers, int numOfBlueAircraftCarriers, int numOfBlueSubmarines, int numOfBlueCruisers) {
        baltic = new Sea(x, y, numOfRedAircraftCarriers, numOfRedSubmarines, numOfRedCruisers, numOfBlueAircraftCarriers, numOfBlueSubmarines, numOfBlueCruisers);
        clearUsedPoints();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                baltic.getSea()[i][j] = "=";
            }
        }
        addUnitsToSea(numOfRedAircraftCarriers, numOfRedSubmarines, numOfRedCruisers, numOfBlueAircraftCarriers, numOfBlueSubmarines, numOfBlueCruisers);
    }

    //Metoda do zerowania tablicy użytych punktów
    public void clearUsedPoints() {
        //Wypełnienie tablicy wartościami 0
        for (int i = 0; i < baltic.getY(); i++) {
            for (int j = 0; j < baltic.getX(); j++) {
                baltic.getPointsUsedOnMap()[i][j] = 0;
            }
        }
    }

    //Metoda dodająca statki na mape w sposób losowy
    public void addUnitsToSea(int numOfRedAircraftCarriers, int numOfRedSubmarines, int numOfRedCruisers, int numOfBlueAircraftCarriers, int numOfBlueSubmarines, int numOfBlueCruisers) {
        int countRedUnits = numOfRedAircraftCarriers + numOfRedSubmarines + numOfRedCruisers;
        int countBlueUnits = numOfBlueAircraftCarriers + numOfBlueSubmarines + numOfBlueCruisers;
        //int countAllUnits = countRedUnits + countBlueUnits;

        //Rzeczy potrzebne do tworzenia randomowych liczb
        Random randomPoints = new Random();
        int xRand;
        int yRand;

        //Dodawanie czerwonych statków do mapy
        while (countRedUnits != 0) {
            do {
                if (baltic.getX() % 2 == 0) {
                    xRand = randomPoints.nextInt(baltic.getX() / 2 - 1);
                } else {
                    xRand = randomPoints.nextInt((baltic.getX() - 1) / 2 - 1);
                }
                yRand = randomPoints.nextInt(baltic.getY());

            } while (!(baltic.getPointsUsedOnMap()[yRand][xRand] == 0));

            if (numOfRedAircraftCarriers != 0) {
                //Dodanie nowego obiektu do listy statków czerwonych
                baltic.getRedShips().add(new AircraftCarrier("Red", xRand, yRand));
                baltic.getSea()[yRand][xRand] = "RA";
                //Zaznaczenie na mapie że w tym miejscu znajduje się czerwony lotniskowiec
                baltic.getPointsUsedOnMap()[yRand][xRand] = 1;
                numOfRedAircraftCarriers--;
                countRedUnits--;
                continue;
            }

            if (numOfRedSubmarines != 0) {
                baltic.getRedShips().add(new Submarine("Red", xRand, yRand));
                baltic.getSea()[yRand][xRand] = "RS";
                baltic.getPointsUsedOnMap()[yRand][xRand] = 1;
                numOfRedSubmarines--;
                countRedUnits--;
                continue;
            }

            if (numOfRedCruisers != 0) {
                baltic.getRedShips().add(new Cruiser("Red", xRand, yRand));
                baltic.getSea()[yRand][xRand] = "RC";
                baltic.getPointsUsedOnMap()[yRand][xRand] = 1;
                numOfRedCruisers--;
                countRedUnits--;
            }
        }

        //Dodawanie niebieskich statków do mapy
        while (countBlueUnits != 0) {
            do {
                if (baltic.getX() % 2 == 0) {
                    xRand = randomPoints.nextInt(baltic.getX() - baltic.getX() / 2) + baltic.getX() / 2;
                } else {
                    xRand = randomPoints.nextInt(baltic.getX() - ((baltic.getX() - 1) / 2 + 1)) + (baltic.getX() - 1) / 2 + 1;
                }
                yRand = randomPoints.nextInt(baltic.getY());

            } while (!(baltic.getPointsUsedOnMap()[yRand][xRand] == 0));

            if (numOfBlueAircraftCarriers != 0) {
                baltic.getBlueShips().add(new AircraftCarrier("Blue", xRand, yRand));
                baltic.getSea()[yRand][xRand] = "BA";
                baltic.getPointsUsedOnMap()[yRand][xRand] = 2;
                numOfBlueAircraftCarriers--;
                countBlueUnits--;
                continue;
            }

            if (numOfBlueSubmarines != 0) {
                baltic.getBlueShips().add(new Submarine("Blue", xRand, yRand));
                baltic.getSea()[yRand][xRand] = "BS";
                baltic.getPointsUsedOnMap()[yRand][xRand] = 2;
                numOfBlueSubmarines--;
                countBlueUnits--;
                continue;
            }

            if (numOfBlueCruisers != 0) {
                baltic.getBlueShips().add(new Cruiser("Blue", xRand, yRand));
                baltic.getSea()[yRand][xRand] = "BC";
                baltic.getPointsUsedOnMap()[yRand][xRand] = 2;
                numOfBlueCruisers--;
                countBlueUnits--;
            }
        }
    }

    //Podgląd tablicy punktow na mapie
    public void printPoints() {
        for (int i = 0; i < baltic.getY(); i++) {
            for (int j = 0; j < baltic.getX(); j++) {
                System.out.print(baltic.getPointsUsedOnMap()[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //Wyświetlenie mapy w konsoli
    public void printSea() {
        System.out.print("   ");
        for (int j = 0; j < baltic.getX(); j++) { //rysowanie współrzędnych
            if (j == baltic.getX() - 1) {
                System.out.printf("%2d", j);
            } else {
                System.out.printf("%2d ", j);
            }
        }
        System.out.println();
        for (int i = 0; i < baltic.getY(); i++) {
            System.out.printf("%2d ", i);//rysowanie współrzędnych
            for (int j = 0; j < baltic.getX(); j++) {
                if (j == baltic.getX() - 1) {
                    System.out.printf("%2s", baltic.getSea()[i][j]);
                } else {
                    System.out.printf("%2s ", baltic.getSea()[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //Metoda umożliwiająca ruch statków
    public void moveAllShips(int firstStart, int numberOfIterations) //firstStart  0-Blue first   1-Red first
    {
        for (int i = 1; i <= numberOfIterations; i++) {
            if (firstStart == 1) {
                for (Ship ship : baltic.getRedShips()) {
                    ship.move(baltic);
                }
                for (Ship ship : baltic.getBlueShips()) {
                    ship.move(baltic);
                }
            }
            if (firstStart == 0) {
                for (Ship ship : baltic.getBlueShips()) {
                    ship.move(baltic);
                }
                for (Ship ship : baltic.getRedShips()) {
                    ship.move(baltic);
                }
            }
        }
    }

    //Metoda umożliwiająca zadanie obrażeń przeciwnikowi
    public void makeDamage() {
        for (Ship ship : baltic.getRedShips()) {
            ship.attack(baltic);
        }
        for (Ship ship : baltic.getBlueShips()) {
            ship.attack(baltic);
        }
    }

    //Podgląd punktów hp danego statku
    public void seeHp() {
        for (Ship ship : baltic.getRedShips()) {
            System.out.println("Team: " + ship.getTeam() + " " + ship.getName() + " HP: " + ship.getHp());
        }
        for (Ship ship : baltic.getBlueShips()) {
            System.out.println("Team: " + ship.getTeam() + " " + ship.getName() + " HP: " + ship.getHp());
        }
        System.out.println();
    }
}

