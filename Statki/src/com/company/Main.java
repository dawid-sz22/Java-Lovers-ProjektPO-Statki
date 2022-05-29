package com.company;

public class Main {

    public static void main(String[] args) {
        SeaCreator balticSea = new SeaCreator(20, 20, 1, 2, 3, 1, 2, 3);

        balticSea.printSea();
        balticSea.moveAllShips(1);
        balticSea.printSea();
    }
}
