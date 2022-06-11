package com.company;

public class Cruiser extends Ship {

    public Cruiser(String team, int positionX, int positionY) {
        super(team, positionX, positionY);
        super.setName("Cruiser");
        super.setHp(600);
        super.setDamage(45);
        super.setAmountOfMoves(1);
        super.setViewRangeX(2);
        super.setViewRangeY(2);
        super.setFireRangeX(2);
        super.setFireRangeY(2);
    }
}
