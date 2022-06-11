package com.company;

public class Submarine extends Ship {

    public Submarine(String team, int positionX, int positionY) {
        super(team, positionX, positionY);
        super.setName("Submarine");
        super.setHp(300);
        super.setDamage(70);
        super.setAmountOfMoves(1);
        super.setViewRangeX(3);
        super.setViewRangeY(3);
        super.setFireRangeX(2);
        super.setFireRangeY(2);
    }
}
