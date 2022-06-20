package com.company;

import java.util.*;

public class Sea {

    //Deklaracja zmiennych definiujących rozmiar planszy
    private int x;
    private int y;

    //Deklaracja zmiennych przechowujących dane o ilości statków oraz potrzebnych do badań nad symulacją
    private int numOfRedAircraftCarriers;
    private int numOfRedSubmarines;
    private int numOfRedCruisers;
    private int numOfBlueAircraftCarriers;
    private int numOfBlueSubmarines;
    private int numOfBlueCruisers;

    private int numOfDeadRedAircraftCarriers;
    private int numOfDeadRedSubmarines;
    private int numOfDeadRedCruisers;

    private int numOfDeadBlueAircraftCarriers;
    private int numOfDeadBlueSubmarines;
    private int numOfDeadBlueCruisers;

    private int countRedAircraftCarriersDamageDealt;
    private int countRedSubmarinesDamageDealt;
    private int countRedCruisersDamageDealt;

    private int countBlueAircraftCarriersDamageDealt;
    private int countBlueSubmarinesDamageDealt;
    private int countBlueCruisersDamageDealt;

    private int countRedAircraftCarriersDamageTaken;
    private int countRedSubmarinesDamageTaken;
    private int countRedCruisersDamageTaken;

    private int countBlueAircraftCarriersDamageTaken;
    private int countBlueSubmarinesDamageTaken;
    private int countBlueCruisersDamageTaken;

    private int countShips;


    //Deklaracja planszy dwuwymiarowej
    private String[][] sea;

    //Tablica przechowująca zajęte punkty na morzu
    private int[][] pointsUsedOnMap; //0-pusto  1-statek RED  2-statek BLUE

    //Dwie listy z obiektami(statkami) danej floty
    private List<Ship> redShips = new ArrayList<>();
    private List<Ship> blueShips = new ArrayList<>();


    //Konstruktor Sea
    Sea(int x, int y) {
        sea = new String[y][x];
        pointsUsedOnMap = new int[y][x];
        this.x = x;
        this.y = y;
    }

    //Konstruktor Sea ze statkami
    public Sea(int x, int y, int numOfRedAircraftCarriers, int numOfRedSubmarines, int numOfRedCruisers, int numOfBlueAircraftCarriers, int numOfBlueSubmarines, int numOfBlueCruisers) {
        this(x, y);
        if (numOfRedAircraftCarriers+numOfRedSubmarines+numOfRedCruisers+numOfBlueAircraftCarriers+numOfBlueSubmarines+numOfBlueCruisers <= (x*y)) { //Sprawdzanie czy nie ma dużej ilości statków na mapę
            this.numOfRedAircraftCarriers = numOfRedAircraftCarriers;
            this.numOfRedSubmarines = numOfRedSubmarines;
            this.numOfRedCruisers = numOfRedCruisers;

            this.numOfBlueAircraftCarriers = numOfBlueAircraftCarriers;
            this.numOfBlueSubmarines = numOfBlueSubmarines;
            this.numOfBlueCruisers = numOfBlueCruisers;
            countShips = numOfRedAircraftCarriers+numOfRedSubmarines+numOfRedCruisers+numOfBlueAircraftCarriers+numOfBlueSubmarines+numOfBlueCruisers;
        }

    }

    //Gettery
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public List<Ship> getRedShips() {
        return redShips;
    }

    public List<Ship> getBlueShips() {
        return blueShips;
    }

    public int getNumOfBlueAircraftCarriers() {
        return numOfBlueAircraftCarriers;
    }

    public int getNumOfBlueCruisers() {
        return numOfBlueCruisers;
    }

    public int getNumOfBlueSubmarines() {
        return numOfBlueSubmarines;
    }

    public int getNumOfRedAircraftCarriers() {
        return numOfRedAircraftCarriers;
    }

    public int getNumOfRedCruisers() {
        return numOfRedCruisers;
    }

    public int getNumOfRedSubmarines() {
        return numOfRedSubmarines;
    }

    public String[][] getSea() {
        return sea;
    }

    public int[][] getPointsUsedOnMap() {
        return pointsUsedOnMap;
    }

    public int getCountShips() {
        return countShips;
    }

    public int getNumOfDeadBlueAircraftCarriers() {
        return numOfDeadBlueAircraftCarriers;
    }

    public int getNumOfDeadBlueCruisers() {
        return numOfDeadBlueCruisers;
    }

    public int getNumOfDeadBlueSubmarines() {
        return numOfDeadBlueSubmarines;
    }

    public int getNumOfDeadRedAircraftCarriers() {
        return numOfDeadRedAircraftCarriers;
    }

    public int getNumOfDeadRedCruisers() {
        return numOfDeadRedCruisers;
    }

    public int getNumOfDeadRedSubmarines() {
        return numOfDeadRedSubmarines;
    }

    public int getCountBlueAircraftCarriersDamageDealt() {
        return countBlueAircraftCarriersDamageDealt;
    }

    public int getCountBlueAircraftCarriersDamageTaken() {
        return countBlueAircraftCarriersDamageTaken;
    }

    public int getCountBlueCruisersDamageDealt() {
        return countBlueCruisersDamageDealt;
    }

    public int getCountBlueCruisersDamageTaken() {
        return countBlueCruisersDamageTaken;
    }

    public int getCountBlueSubmarinesDamageDealt() {
        return countBlueSubmarinesDamageDealt;
    }

    public int getCountBlueSubmarinesDamageTaken() {
        return countBlueSubmarinesDamageTaken;
    }

    public int getCountRedAircraftCarriersDamageDealt() {
        return countRedAircraftCarriersDamageDealt;
    }

    public int getCountRedAircraftCarriersDamageTaken() {
        return countRedAircraftCarriersDamageTaken;
    }

    public int getCountRedCruisersDamageDealt() {
        return countRedCruisersDamageDealt;
    }

    public int getCountRedCruisersDamageTaken() {
        return countRedCruisersDamageTaken;
    }

    public int getCountRedSubmarinesDamageDealt() {
        return countRedSubmarinesDamageDealt;
    }

    public int getCountRedSubmarinesDamageTaken() {
        return countRedSubmarinesDamageTaken;
    }


    //Set'ery
    public void setBlueShips(List<Ship> blueShips) {
        this.blueShips = blueShips;
    }

    public void setNumOfBlueAircraftCarriers(int numOfBlueAircraftCarriers) {
        this.numOfBlueAircraftCarriers = numOfBlueAircraftCarriers;
    }

    public void setNumOfBlueCruisers(int numOfBlueCruisers) {
        this.numOfBlueCruisers = numOfBlueCruisers;
    }

    public void setNumOfBlueSubmarines(int numOfBlueSubmarines) {
        this.numOfBlueSubmarines = numOfBlueSubmarines;
    }

    public void setNumOfRedAircraftCarriers(int numOfRedAircraftCarriers) {
        this.numOfRedAircraftCarriers = numOfRedAircraftCarriers;
    }

    public void setNumOfRedCruisers(int numOfRedCruisers) {
        this.numOfRedCruisers = numOfRedCruisers;
    }

    public void setRedShips(List<Ship> redShips) {
        this.redShips = redShips;
    }

    public void setNumOfRedSubmarines(int numOfRedSubmarines) {
        this.numOfRedSubmarines = numOfRedSubmarines;
    }

    public void setSea(String[][] sea) {
        this.sea = sea;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPointsUsedOnMap(int[][] pointsUsedOnMap) {
        this.pointsUsedOnMap = pointsUsedOnMap;
    }


    public void setCountShips(int countShips) {
        this.countShips = countShips;
    }

    public void setNumOfDeadBlueAircraftCarriers(int numOfDeadBlueAircraftCarriers) {
        this.numOfDeadBlueAircraftCarriers = numOfDeadBlueAircraftCarriers;
    }

    public void setNumOfDeadBlueCruisers(int numOfDeadBlueCruisers) {
        this.numOfDeadBlueCruisers = numOfDeadBlueCruisers;
    }

    public void setNumOfDeadBlueSubmarines(int numOfDeadBlueSubmarines) {
        this.numOfDeadBlueSubmarines = numOfDeadBlueSubmarines;
    }

    public void setNumOfDeadRedAircraftCarriers(int numOfDeadRedAircraftCarriers) {
        this.numOfDeadRedAircraftCarriers = numOfDeadRedAircraftCarriers;
    }

    public void setNumOfDeadRedCruisers(int numOfDeadRedCruisers) {
        this.numOfDeadRedCruisers = numOfDeadRedCruisers;
    }

    public void setNumOfDeadRedSubmarines(int numOfDeadRedSubmarines) {
        this.numOfDeadRedSubmarines = numOfDeadRedSubmarines;
    }

    public void setCountBlueAircraftCarriersDamageDealt(int countBlueAircraftCarriersDamageDealt) {
        this.countBlueAircraftCarriersDamageDealt = countBlueAircraftCarriersDamageDealt;
    }

    public void setCountBlueAircraftCarriersDamageTaken(int countBlueAircraftCarriersDamageTaken) {
        this.countBlueAircraftCarriersDamageTaken = countBlueAircraftCarriersDamageTaken;
    }

    public void setCountBlueCruisersDamageDealt(int countBlueCruisersDamageDealt) {
        this.countBlueCruisersDamageDealt = countBlueCruisersDamageDealt;
    }

    public void setCountBlueCruisersDamageTaken(int countBlueCruisersDamageTaken) {
        this.countBlueCruisersDamageTaken = countBlueCruisersDamageTaken;
    }

    public void setCountBlueSubmarinesDamageDealt(int countBlueSubmarinesDamageDealt) {
        this.countBlueSubmarinesDamageDealt = countBlueSubmarinesDamageDealt;
    }

    public void setCountBlueSubmarinesDamageTaken(int countBlueSubmarinesDamageTaken) {
        this.countBlueSubmarinesDamageTaken = countBlueSubmarinesDamageTaken;
    }

    public void setCountRedAircraftCarriersDamageDealt(int countRedAircraftCarriersDamageDealt) {
        this.countRedAircraftCarriersDamageDealt = countRedAircraftCarriersDamageDealt;
    }

    public void setCountRedAircraftCarriersDamageTaken(int countRedAircraftCarriersDamageTaken) {
        this.countRedAircraftCarriersDamageTaken = countRedAircraftCarriersDamageTaken;
    }

    public void setCountRedCruisersDamageDealt(int countRedCruisersDamageDealt) {
        this.countRedCruisersDamageDealt = countRedCruisersDamageDealt;
    }

    public void setCountRedCruisersDamageTaken(int countRedCruisersDamageTaken) {
        this.countRedCruisersDamageTaken = countRedCruisersDamageTaken;
    }

    public void setCountRedSubmarinesDamageDealt(int countRedSubmarinesDamageDealt) {
        this.countRedSubmarinesDamageDealt = countRedSubmarinesDamageDealt;
    }

    public void setCountRedSubmarinesDamageTaken(int countRedSubmarinesDamageTaken) {
        this.countRedSubmarinesDamageTaken = countRedSubmarinesDamageTaken;
    }

}
