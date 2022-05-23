package com.company;

public class Submarine extends Ship{


    Submarine() {
        super();
    }
    Submarine(String team, int positionX, int positionY)
    {
        super(team,positionX,positionY);
        super.setName("Submarine");
        super.setDamage(70);
        super.setHp(300);
        super.setFireRangeX(2);
        super.setFireRangeY(2);
        super.setViewRangeX(3);
        super.setViewRangeY(3);
        super.setPositionChangeX(1);
        super.setPositionChangeY(1);
    }

    //constructor to copy object ???
    Submarine(Submarine submarine)
    {
        super(submarine);
        super.setName("Submarine");
    }

}
