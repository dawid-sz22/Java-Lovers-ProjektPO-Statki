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

    private int countShips;
    private int countDeadRedShips;
    private int countDeadBlueShips;


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
        pointsUsedOnMap = new int[x][y];
        this.x = x;
        this.y = y;
    }

    //Konstruktor Sea ze statkami
    public Sea(int x, int y, int numOfRedAircraftCarriers, int numOfRedSubmarines, int numOfRedCruisers, int numOfBlueAircraftCarriers, int numOfBlueSubmarines, int numOfBlueCruisers) {
        this(x, y);
        countShips = numOfRedAircraftCarriers + numOfBlueSubmarines + numOfRedCruisers + numOfBlueAircraftCarriers + numOfBlueSubmarines +numOfBlueCruisers;
        this.numOfRedAircraftCarriers = numOfRedAircraftCarriers;
        this.numOfRedSubmarines = numOfRedSubmarines;
        this.numOfRedCruisers = numOfRedCruisers;

        this.numOfBlueAircraftCarriers = numOfBlueAircraftCarriers;
        this.numOfBlueSubmarines = numOfBlueSubmarines;
        this.numOfBlueCruisers = numOfBlueCruisers;
    }

    public void countShipsPlus(int x)
    {
        this.countShips += x;
    }

    public void countDeadBlueShipsPlus(int x)
    {
        this.countDeadBlueShips += x;
    }

    public void countDeadRedShipsPlus(int x)
    {
        this.countDeadRedShips += x;
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

    public int getCountDeadBlueShips() {
        return countDeadBlueShips;
    }

    public int getCountDeadRedShips() {
        return countDeadRedShips;
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

    public void setCountDeadBlueShips(int countDeadBlueShips) {
        this.countDeadBlueShips = countDeadBlueShips;
    }

    public void setCountDeadRedShips(int countDeadRedShips) {
        this.countDeadRedShips = countDeadRedShips;
    }

    public void setCountShips(int countShips) {
        this.countShips = countShips;
    }
}
