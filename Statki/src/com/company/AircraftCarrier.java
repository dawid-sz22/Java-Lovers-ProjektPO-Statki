package com.company;

public class AircraftCarrier {

    private final String name;
    private final String team;

    private int hp = 1000;
    private final int damage = 40;

    private int positionX;
    private int positionY;

    private int fireRangeX = 1;
    private int fireRangeY = 1;

    private final int viewRangeX = 1;
    private final int viewRangeY = 1;

    private int positionChangeX = 1;
    private int positionChangeY = 1;

    public AircraftCarrier(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
