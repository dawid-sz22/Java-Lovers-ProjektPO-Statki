package com.company;

public class Main {

    public static void main(String[] args) {
        SeaCreator balticSea = new SeaCreator(20, 20, 1, 2, 3, 1, 2, 3);

        balticSea.printSea();

        for(int i = 0; i < 20; i++) {
            balticSea.moveAllShips(1, 1);
            balticSea.makeDamage();
            balticSea.removeDeadUnitsFromTheList();
            balticSea.printSea();
            balticSea.seeHp();
        }
        //Zrobiłem taką pętle, bo ławiej mi było sprawdzać, czy się nie pomyliłem gdzieś w kodzie i czy wszystko działa poprawnie
    }
}
