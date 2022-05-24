package com.company;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sea {

    private int x;
    private int y;
    private int RedAmountAircraftCarriers;
    private int RedAmountSubmarines;
    private int RedAmountCruisers;
    private int BlueAmountAircraftCarriers;
    private int BlueAmountSubmarines;
    private int BlueAmountCruisers;
    String[][] sea;

    Sea() //default constructor
    {
        x = 1;
        y = 1;
        sea = new String[1][1];
        sea[0][0] = "-1";
    }

    Sea(int x, int y) //constructor to create sea X x Y
    {
        sea = new String[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sea[i][j] = "=";
            }
        }
        this.x = x;
        this.y = y;
    }

    //constructor to create sea X x Y, with amount of particular ships in each team
    Sea(int x, int y, int RedAmountAircraftCarriers, int RedAmountSubmarines, int RedAmountCruisers, int BlueAmountAircraftCarriers, int BlueAmountSubmarines, int BlueAmountCruisers)
    {
        this(x, y);
        addUnits(RedAmountAircraftCarriers,RedAmountSubmarines,RedAmountCruisers,BlueAmountAircraftCarriers,BlueAmountSubmarines,BlueAmountCruisers);
    }

    //method to add units on sea
    public void addUnits(int RedAmountAircraftCarriers, int RedAmountSubmarines,int RedAmountCruisers,int BlueAmountAircraftCarriers, int BlueAmountSubmarines, int BlueAmountCruisers)
    {
        this.RedAmountAircraftCarriers = RedAmountAircraftCarriers;
        this.RedAmountSubmarines = RedAmountSubmarines;
        this.RedAmountCruisers = RedAmountCruisers;

        this.BlueAmountAircraftCarriers = BlueAmountAircraftCarriers;
        this.BlueAmountSubmarines = BlueAmountSubmarines;
        this.BlueAmountCruisers = BlueAmountCruisers;

        int countUnits = RedAmountAircraftCarriers + RedAmountCruisers + RedAmountSubmarines + BlueAmountAircraftCarriers + BlueAmountCruisers + BlueAmountSubmarines; //count all units
        List<String> pointsUsed = new ArrayList<String>(); //list which contains used x and y
        Random random = new Random();
        Integer xRand; //random variable x
        Integer yRand; //random variable y

        while (countUnits!=0) {
            //RED SIDE
            if (RedAmountAircraftCarriers + RedAmountCruisers + RedAmountSubmarines != 0) {
                do {
                    if (x % 2 == 0)
                        xRand = random.nextInt(x / 2);
                    else
                        xRand = random.nextInt((x - 1) / 2);
                    yRand = random.nextInt(y);
                } while (pointsUsed.contains(xRand.toString() + yRand.toString())); //if contains used (x,y) find next one

                if (RedAmountAircraftCarriers != 0) {
                    sea[yRand][xRand] = "RA";
                    pointsUsed.add(xRand.toString() + yRand.toString());
                    RedAmountAircraftCarriers--;
                    countUnits--;
                    continue;
                }
                if (RedAmountCruisers != 0) {
                    sea[yRand][xRand] = "RC";
                    pointsUsed.add(xRand.toString() + yRand.toString());
                    RedAmountCruisers--;
                    countUnits--;
                    continue;
                }
                if (RedAmountSubmarines != 0) {
                    sea[yRand][xRand] = "RS";
                    pointsUsed.add(xRand.toString() + yRand.toString());
                    RedAmountSubmarines--;
                    countUnits--;
                    continue;
                }
            } else
                //BLUE SIDE
                do {
                    if (x % 2 == 0)
                        xRand = random.nextInt(x - x/2) + x/2;
                    else
                        xRand = random.nextInt(x - (x-1)/2 + 1) +(x-1)/2 + 1;
                    yRand = random.nextInt(y);
                } while (pointsUsed.contains(xRand.toString() + yRand.toString()));

                if (BlueAmountAircraftCarriers != 0) {
                    sea[yRand][xRand] = "BA";
                    pointsUsed.add(xRand.toString() + yRand.toString());
                    BlueAmountAircraftCarriers--;
                    countUnits--;
                    continue;
                }
                if (BlueAmountSubmarines != 0) {
                    sea[yRand][xRand] = "BS";
                    pointsUsed.add(xRand.toString() + yRand.toString());
                    System.out.println("benc");  // <---------- WYŚWIETLA 2X POMIMO, ŻE NA PRINTCIE MAPY SĄ 3X ?????
                    BlueAmountSubmarines--;
                    countUnits--;
                    continue;
                }
                if (BlueAmountCruisers != 0) {
                    sea[yRand][xRand] = "BC";
                    pointsUsed.add(xRand.toString() + yRand.toString());
                    BlueAmountCruisers--;
                    countUnits--;
                    continue;
                }
        }
    }


    public void print() //print map of sea in console
    {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(sea[i][j] + "  ");
                if (j == x-1)
                    System.out.print(sea[i][j]);
            }
            System.out.println();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
