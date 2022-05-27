package com.company;

public class AircraftCarrier extends Ship {

    public AircraftCarrier(String team, int positionX, int positionY) {
        super(team, positionX, positionY);
        super.setName("AircraftCarrier");
        super.setHp(1000);
        super.setDamage(40);
        super.setPositionChangeX(2);
        super.setPositionChangeY(2);
        super.setViewRangeX(1);
        super.setViewRangeY(1);
        super.setFireRangeX(1);
        super.setFireRangeY(1);
    }
}
