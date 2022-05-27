package com.company;

public abstract class Ship {

    //Deklaracja podstawowych parametrów dla klasy abstrakcyjnej Ship
    private String name;
    private String team;

    private int hp;
    private int damage;

    private int positionX;
    private int positionY;

    private int positionChangeX;
    private int positionChangeY;

    private int viewRangeX;
    private int viewRangeY;

    private int fireRangeX;
    private int fireRangeY;

    public static int countShips;

    //Konstruktor
    public Ship(String team, int positionX, int positionY) {
        countShips++;
        this.team = team;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //Settery
    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPositionChangeX(int positionChangeX) {
        this.positionChangeX = positionChangeX;
    }

    public void setPositionChangeY(int positionChangeY) {
        this.positionChangeY = positionChangeY;
    }

    public void setViewRangeX(int viewRangeX) {
        this.viewRangeX = viewRangeX;
    }

    public void setViewRangeY(int viewRangeY) {
        this.viewRangeY = viewRangeY;
    }

    public void setFireRangeX(int fireRangeX) {
        this.fireRangeX = fireRangeX;
    }

    public void setFireRangeY(int fireRangeY) {
        this.fireRangeY = fireRangeY;
    }

    //Gettery
    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionChangeX() {
        return positionChangeX;
    }

    public int getPositionChangeY() {
        return positionChangeY;
    }

    public int getViewRangeX() {
        return viewRangeX;
    }

    public int getViewRangeY() {
        return viewRangeY;
    }

    public int getFireRangeX() {
        return fireRangeX;
    }

    public int getFireRangeY() {
        return fireRangeY;
    }
}
