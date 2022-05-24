package com.company;

public class AircraftCarrier extends Ship {

    AircraftCarrier() {
        super();
    }
    AircraftCarrier(String team, int positionX, int positionY)
    {
        super(team, positionX, positionY);
        super.setName("AircraftCarrier");
        super.setDamage(40);
        super.setHp(1000);
        super.setFireRangeX(1);
        super.setFireRangeY(1);
        super.setViewRangeX(1);
        super.setViewRangeY(1);
        super.setPositionChangeX(2);
        super.setPositionChangeY(2);
    }

    //constructor to copy object ???
    AircraftCarrier(AircraftCarrier aircraftCarrier)
    {
        super(aircraftCarrier);
        super.setName("Lotniskowiec");
    }


}
