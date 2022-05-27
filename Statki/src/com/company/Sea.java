package com.company;

import java.util.*;

public class Sea {

    //Deklaracja zmiennych definiujących rozmiar planszy
    private int x;
    private int y;

    //Deklaracja zmiennych przechowujących dane o ilości statków
    private int numOfRedAircraftCarriers;
    private int numOfRedSubmarines;
    private int numOfRedCruisers;
    private int numOfBlueAircraftCarriers;
    private int numOfBlueSubmarines;
    private int numOfBlueCruisers;

    //Deklaracja planszy dwuwymiarowej
    String[][] sea;

    //Konstruktor Sea
    Sea(int x, int y) {

        sea = new String[y][x];
        this.x = x;
        this.y = y;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sea[i][j] = "=";
            }
        }
    }

    //Konstruktor Sea ze statkami
    public Sea(int x, int y, int numOfRedAircraftCarriers, int numOfRedSubmarines, int numOfRedCruisers, int numOfBlueAircraftCarriers, int numOfBlueSubmarines, int numOfBlueCruisers) {

        this(x, y);
        addUnitsToSea(numOfRedAircraftCarriers, numOfRedSubmarines, numOfRedCruisers, numOfBlueAircraftCarriers, numOfBlueSubmarines, numOfBlueCruisers);
    }

    //Metoda dodająca statki na mape w spsób losowy
    public void addUnitsToSea(int numOfRedAircraftCarriers, int numOfRedSubmarines, int numOfRedCruisers, int numOfBlueAircraftCarriers, int numOfBlueSubmarines, int numOfBlueCruisers) {

        this.numOfRedAircraftCarriers = numOfRedAircraftCarriers;
        this.numOfRedSubmarines = numOfRedSubmarines;
        this.numOfRedCruisers = numOfRedCruisers;

        this.numOfBlueAircraftCarriers = numOfBlueAircraftCarriers;
        this.numOfBlueSubmarines = numOfBlueSubmarines;
        this.numOfBlueCruisers = numOfBlueCruisers;

        int countRedUnits = numOfRedAircraftCarriers + numOfRedSubmarines + numOfRedCruisers;
        int countBlueUnits = numOfBlueAircraftCarriers + numOfBlueSubmarines + numOfBlueCruisers;
        //int countAllUnits = countRedUnits + countBlueUnits;

        //Dwuwymiarowa tablica zawierająca punkty na mapie 0-puste, 1-red, 2-blue
        int[][] pointsUsedOnMap = new int[y][x];

        //Wypełnienie tablicy wartościami 0
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                pointsUsedOnMap[i][j] = 0;
            }
        }

        //Rzeczy potrzebne do tworzenia randomowych liczb
        Random randomPoints = new Random();
        int xRand;
        int yRand;

        //Dwie listy z obiektami(statkami) danej floty
        List<Ship> redShips = new ArrayList<>();
        List<Ship> blueShips = new ArrayList<>();

        //Dodawanie czerwonych statków do mapy
        while (countRedUnits != 0) {
            do {
                if (x % 2 == 0) {
                    xRand = randomPoints.nextInt(x / 2);
                } else {
                    xRand = randomPoints.nextInt((x - 1) / 2);
                }
                yRand = randomPoints.nextInt(y);

            } while (!(pointsUsedOnMap[yRand][xRand] == 0));

            if (numOfRedAircraftCarriers != 0) {
                //Dodanie nowego obiektu do listy statków czerwonych
                redShips.add(new AircraftCarrier("Red", xRand, yRand));
                sea[yRand][xRand] = "RA";
                //Zaznaczenie na mapie że w tym miejscu znajduje się czerwony lotniskowiec
                pointsUsedOnMap[yRand][xRand] = 1;
                numOfRedAircraftCarriers--;
                countRedUnits--;
                continue;
            }

            if (numOfRedSubmarines != 0) {
                redShips.add(new Submarine("Red", xRand, yRand));
                sea[yRand][xRand] = "RS";
                pointsUsedOnMap[yRand][xRand] = 1;
                numOfRedSubmarines--;
                countRedUnits--;
                continue;
            }

            if (numOfRedCruisers != 0) {
                redShips.add(new Cruiser("Red", xRand, yRand));
                sea[yRand][xRand] = "RC";
                pointsUsedOnMap[yRand][xRand] = 1;
                numOfRedCruisers--;
                countRedUnits--;
            }
        }

        //Dodawanie niebieskich statków do mapy
        while (countBlueUnits != 0) {
            do {
                if (x % 2 == 0) {
                    xRand = randomPoints.nextInt(x - x / 2) + x / 2;
                } else {
                    xRand = randomPoints.nextInt(x - (x - 1) / 2 + 1) + (x - 1) / 2 + 1;
                }
                yRand = randomPoints.nextInt(y);

            } while (!(pointsUsedOnMap[yRand][xRand] == 0));

            if (numOfBlueAircraftCarriers != 0) {
                blueShips.add(new AircraftCarrier("Blue", xRand, yRand));
                sea[yRand][xRand] = "BA";
                pointsUsedOnMap[yRand][xRand] = 2;
                numOfBlueAircraftCarriers--;
                countBlueUnits--;
                continue;
            }

            if (numOfBlueSubmarines != 0) {
                blueShips.add(new Submarine("Blue", xRand, yRand));
                sea[yRand][xRand] = "BS";
                pointsUsedOnMap[yRand][xRand] = 2;
                numOfBlueSubmarines--;
                countBlueUnits--;
                continue;
            }

            if (numOfBlueCruisers != 0) {
                blueShips.add(new Cruiser("Blue", xRand, yRand));
                sea[yRand][xRand] = "BC";
                pointsUsedOnMap[yRand][xRand] = 2;
                numOfBlueCruisers--;
                countBlueUnits--;
            }
        }

        //Podgląd tablicy punktow na mapie
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(pointsUsedOnMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //Wyświetlenie mapy w konsoli
    public void printSea() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (j == x-1) {
                    System.out.print(sea[i][j]);
                } else {
                    System.out.print(sea[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
