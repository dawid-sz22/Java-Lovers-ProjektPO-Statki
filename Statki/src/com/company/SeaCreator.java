package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SeaCreator {

    Sea baltic;

    int countStages = 0;

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
    public void printSea()
    {
            StringBuilder print = new StringBuilder(new String());

            print.append(" ".repeat(((3 + baltic.getX() * 3) - 8) / 2));
            print.append(String.format("Stage %2d", countStages));
            print.append(" ".repeat(((3 + baltic.getX() * 3) - 8) / 2));
            print.append("\n   ");
            for (int j = 0; j < baltic.getX(); j++) { //rysowanie współrzędnych
                if (j == baltic.getX() - 1) {
                    print.append(String.format("%2d", j));
                } else {
                    print.append(String.format("%2d ", j));
                }
            }
            print.append("\n");
            for (int i = 0; i < baltic.getY(); i++) {
                print.append(String.format("%2d ", i));//rysowanie współrzędnych
                for (int j = 0; j < baltic.getX(); j++) {
                    if (j == baltic.getX() - 1) {
                        print.append(String.format("%2s", baltic.getSea()[i][j]));
                    } else {
                        print.append(String.format("%2s ", baltic.getSea()[i][j]));
                    }
                }
                print.append("\n");
            }
            print.append("\n");
            System.out.print(print);
    }

    //Metoda umożliwiająca ruch statków
    public void moveAllShips(int firstStart) //firstStart  0-Blue first   1-Red first
    {
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

    public void stage(int firstStart, int typeStage, int numberOfIterations)
    {
        Scanner x = new Scanner(System.in);
        int select;
        for (int i = 0; i < numberOfIterations; i++)
        {
            if (typeStage == 0) //symulacja z plikiem, bez wyświetlania
            {
                moveAllShips(firstStart);
                makeDamage();
                countStages++;
            }
            if (typeStage == 1) //symulacja z wyświetleniem na jej końcu statystyk i mapy
            {
                moveAllShips(firstStart);
                makeDamage();
                countStages++;
                if (i==(numberOfIterations-1))
                {
                    printSea();
                    seeHp();
                }
            }
            if (typeStage == 2) //symulacja z przerwami
            {
                moveAllShips(firstStart);
                makeDamage();
                countStages++;
                printSea();
                while (true) {
                    System.out.print("Kliknij 1, aby wyświetlić statystyki lub wciśnij 9, aby przejść do kolejnej tury");
                    if (x.hasNextInt())
                        select = x.nextInt();
                    else
                    {
                        x.nextLine();
                        System.out.print("Podano złe wejście! Spróbuj ponownie! ");
                        continue;
                    }
                    if (select == 1) seeHp();
                    if (select == 9) break;
                }
            }
        }
    }

    public void stage(int firstStart, int typeStage, int numberOfIterations, String fileName)
    {
        Scanner x = new Scanner(System.in);
        int select;
        for (int i = 0; i < numberOfIterations; i++)
        {
            if (typeStage == 0) //symulacja z plikiem, bez wyświetlania
            {
                moveAllShips(firstStart);
                makeDamage();
                countStages++;
            }
            if (typeStage == 1) //symulacja z wyświetleniem na jej końcu statystyk i mapy
            {
                moveAllShips(firstStart);
                makeDamage();
                countStages++;
                if (i==(numberOfIterations-1))
                {
                    printSea();
                    seeHp();
                }
            }
            if (typeStage == 2) //symulacja z przerwami
            {
                moveAllShips(firstStart);
                makeDamage();
                countStages++;
                printSea();
                while (true) {
                    System.out.print("Kliknij 1, aby wyświetlić statystyki lub wciśnij 9, aby przejść do kolejnej tury");
                    if (x.hasNextInt())
                        select = x.nextInt();
                    else
                    {
                        x.nextLine();
                        System.out.print("Podano złe wejście! Spróbuj ponownie! ");
                        continue;
                    }
                    if (select == 1) seeHp();
                    if (select == 9) break;
                }
            }
        }
        if (typeStage==0)
        {
            try (FileWriter writer = new FileWriter("./Tests/RESULT"+fileName,true))
            {
                writer.write(baltic.getX()+";"+baltic.getY()+";"+ baltic.getNumOfRedAircraftCarriers()+";"+ baltic.getNumOfRedSubmarines()+";"+ baltic.getNumOfRedCruisers()
                        +";"+ baltic.getNumOfBlueAircraftCarriers()+";"+ baltic.getNumOfBlueSubmarines()+";"+ baltic.getNumOfBlueCruisers()+";"+firstStart+";"+countStages
                        +";"+baltic.getCountShips()+";"+baltic.getCountDeadRedShips()+";"+baltic.getCountDeadBlueShips());
                writer.write("\n");
            }
            catch (IOException exception)
            {
                System.out.println("Błąd w zapisywaniu!");
            }
        }
    }
}

