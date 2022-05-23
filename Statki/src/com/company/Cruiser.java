package com.company;

public class Cruiser extends Ship{

    Cruiser() {
        super();
    }

    Cruiser(String team, int positionX, int positionY)
    {
        super(team,positionX,positionY);
        super.setName("Cruiser");
        super.setDamage(45);
        super.setHp(600);
        super.setFireRangeX(2);
        super.setFireRangeY(2);
        super.setViewRangeX(2);
        super.setViewRangeY(2);
        super.setPositionChangeX(1);
        super.setPositionChangeY(1);
    }

    //constructor to copy object ???
    Cruiser(Cruiser cruiser)
    {
        super(cruiser);
        super.setName("Krążownik");
    }


}
