package com.company;

public abstract class Ship {
    private String name;
    private String team;

    public static int countShips;

    private int positionX;
    private int positionY;
    private int positionChangeX;
    private int positionChangeY;
    private int hp;
    private int damage;
    private int viewRangeX;
    private int viewRangeY;
    private int fireRangeX;
    private int fireRangeY;

    Ship()
    {
        countShips++;
        positionX = positionY = positionChangeY = positionChangeX = hp = damage = viewRangeX = viewRangeY = fireRangeX =fireRangeY = -1;
        name = team = "None";
    }

    Ship(String team, int positionX,int positionY)
    {
        countShips++;
        this.team = team;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //constructor to copy object ???
    Ship(Ship ship)
    {
        this(ship.team,ship.positionX,ship.positionY);
        this.name = ship.name;
        this.damage = ship.damage;
        this.hp = ship.hp;
        this.positionChangeY = ship.positionChangeY;
        this.positionChangeX = ship.positionChangeX;
        this.viewRangeX = ship.viewRangeX;
        this.viewRangeY = ship.viewRangeY;
        this.fireRangeX = ship.fireRangeX;
        this.fireRangeY = ship.fireRangeY;
    }


    public String getName() {
        return name;
    }
    public String getTeam() {
        return team;
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
    public int getDamage() {
        return damage;
    }
    public int getHp() {
        return hp;
    }
    public int getViewRangeX() {
        return damage;
    }
    public int getViewRangeY() {
        return damage;
    }
    public int getFireRangeX() {
        return damage;
    }
    public int getFireRangeY() {
        return damage;
    }



    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setFireRangeX(int fireRangeX) {
        this.fireRangeX = fireRangeX;
    }

    public void setFireRangeY(int fireRangeY) {
        this.fireRangeY = fireRangeY;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositionChangeX(int positionChangeX) {
        this.positionChangeX = positionChangeX;
    }

    public void setPositionChangeY(int positionChangeY) {
        this.positionChangeY = positionChangeY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setViewRangeX(int viewRangeX) {
        this.viewRangeX = viewRangeX;
    }

    public void setViewRangeY(int viewRangeY) {
        this.viewRangeY = viewRangeY;
    }
}