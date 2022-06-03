package com.company;

import java.util.*;

public abstract class Ship {

    //Deklaracja podstawowych parametrów dla klasy abstrakcyjnej Ship
    private String name;
    private final String team;

    private int hp;
    private int damage;

    private int positionX;
    private int positionY;

    private int positionChangeX;
    private int positionChangeY;
    private boolean directionMove; //false - kierunek poruszania --->>>     true - kierunek poruszania <<<-----

    private int viewRangeX;
    private int viewRangeY;

    private int fireRangeX;
    private int fireRangeY;

    public static int countShips;
    private boolean isAlive;

    //Konstruktor
    public Ship(String team, int positionX, int positionY) {
        countShips++;
        this.team = team;
        this.positionX = positionX;
        this.positionY = positionY;

        if (team.equals("Red")) directionMove = false;  //red --->
        if (team.equals("Blue")) directionMove = true;  //blue <---
        isAlive = true;
    }

    //Metoda umożliwiająca ruch pojedynczego statku na mapie
    public void move(Sea sea)
    {
        LinkedHashMap<Integer,ArrayList<Integer>> pointsToUse = new LinkedHashMap<>(); //kolekcja przechowująca punkty, które mogą zostać użyte do poruszenia się

        ArrayList<Integer> listOfY = new ArrayList<>(); //lista1 y-ków, która będzie przypisana do poszczególnego x-a
        ArrayList<Integer> listOfY2; //lista2 y-ków, która będzie przypisana do poszczególnego x-a

        //ograniczenia wychodzenia poza tablice z boków
        if(positionX == 0) directionMove = false; //zmiana kierunku na --->>>
        if(positionX == sea.getX() - 1) directionMove = true; //zmiana kierunku na <<<----

        //ograniczenia wychodzenia poza tablice z góry
        if(positionY == 0)
            {
                listOfY.add(0); //w tym wypadku można poruszać się tylko w tym samym y lub w dół
                listOfY.add(1);
            }
        else if(positionY == sea.getY() - 1) //ograniczenia wychodzenia poza tablice z dołu
            {
                listOfY.add(-1); //w tym wypadku można poruszać się tylko w góre lub w tym samym y
                listOfY.add(0);
            }
        else
            {
                listOfY.add(-1); //w tym wypadku można poruszać się w góre, po tym samym y lub w dół
                listOfY.add(0);
                listOfY.add(1);
            }

        listOfY2 = new ArrayList<>(listOfY); //duplikowanie listy

        //ustalanie kierunku ruchu
        if (directionMove) {
            pointsToUse.put(-1,listOfY); //w tym wypadku można poruszać się w lewo lub w tym samym x
            pointsToUse.put(0,listOfY2);
        }
        else {
            pointsToUse.put(0,listOfY); //w tym wypadku można poruszać się w prawo lub w tym samym x
            pointsToUse.put(1,listOfY2);
        }

        //zmienne do losowania punktu
        Set<Integer> keySet = pointsToUse.keySet(); //pomocnicze kolekcje do przechowywania zbioru x-ów
        Integer[] keyArray = keySet.toArray(new Integer[keySet.size()]); //pomocnicze kolekcje do przechowywania zbioru x-ów
        Random random = new Random();
        int xRand;
        int yRand;
        int countPointsToUse = 0;

        for (Integer c: keyArray) { //zliczanie ilości dostępnych punktów
            countPointsToUse += pointsToUse.get(c).size();
        }

        while (countPointsToUse>0)
        {
            keySet = pointsToUse.keySet(); //update keySetu po usunięciu punktu niezdatnego do użycia
            keyArray = keySet.toArray(new Integer[keySet.size()]);

            xRand = random.nextInt(keyArray[1]-keyArray[0]+1)+keyArray[0]; //losowanie x z przedziału np. -1 do 0
            ArrayList<Integer> keyValues = pointsToUse.get(xRand); //z wylosowanego x-a, zdobądź dostępne y-ki

            if (keyValues.size()>0) //sprawdź czy pula dostępnych y jest większa od 0
            {
                yRand = random.nextInt(keyValues.get(keyValues.size() - 1) - keyValues.get(0) + 1) + keyValues.get(0); //losowanie x z przedziału np. -1 do 1
                pointsToUse.get(xRand).remove(Integer.valueOf(yRand)); //sprawdzony punkt x,y, usuń z kolekcji (a dokładnie usuń y z konkretnego x-a)

                if (xRand == 0 && yRand == 0) //jesli to ten sam punkt, na którym znajduje sie statek, pomiń iteracje
                {
                    countPointsToUse--; //zmniejsz ilość punktów do sprawdzenia
                    continue;
                }
                if (sea.getPointsUsedOnMap()[positionY + yRand][positionX + xRand] == 0)  //jeśli sprawdzane miejsce jest puste, zmień koordynaty statku
                {
                    sea.getPointsUsedOnMap()[positionY][positionX] = 0; //zmiana stanu zajęcia punktu z (1;2) na 0
                    sea.getSea()[positionY][positionX] = "="; //zmiana stanu wyświetlania morza z R/B na =

                    positionY = positionY + yRand;
                    positionX = positionX + xRand;

                    if (team.equals("Red")) {
                        sea.getPointsUsedOnMap()[positionY][positionX] = 1; //zmiana stanu zajęcia punktu z 0 na 1
                        if (name.equals("AircraftCarrier")) sea.getSea()[positionY][positionX] = "RA"; //zmiana stanu wyświetlania morza z = na RA
                        if (name.equals("Cruiser")) sea.getSea()[positionY][positionX] = "RC";
                        if (name.equals("Submarine")) sea.getSea()[positionY][positionX] = "RS";
                    }
                    if (team.equals("Blue")) {
                        sea.getPointsUsedOnMap()[positionY][positionX] = 2; //zmiana stanu zajęcia punktu z 0 na 2
                        if (name.equals("AircraftCarrier")) sea.getSea()[positionY][positionX] = "BA"; //zmiana stanu wyświetlania morza z = na BA
                        if (name.equals("Cruiser")) sea.getSea()[positionY][positionX] = "BC";
                        if (name.equals("Submarine")) sea.getSea()[positionY][positionX] = "BS";
                    }

                    break; //statek zmienił pozycje, zatem zakoncz metode
                }

                countPointsToUse--; //zmniejsz ilość punktów do sprawdzenia
            }
        }
    }

    //Metoda umożliwiająca zadanie obrażeń przeciwnikowi w zasięgu ognia
    public void attack(Sea sea)
    {
        if (team.equals("Blue")) { //sprawdzamy team
            for (Ship ship : sea.getRedShips()) {
                if ((Math.abs(positionX - ship.getPositionX()) <= fireRangeX) && (Math.abs(positionY - ship.getPositionY()) <= fireRangeY)) { // sprawdzenie potencjalnych celów w polu rażenia
                    ship.receiveDamage(damage); // przeciwnik przyjmuje obrażenie
                    break; // po oddaniu jednego strzała kończy serie
                }
            }
        }
        //to samo z czerwonymi
        if (team.equals("Red")) {
            for (Ship ship : sea.getBlueShips()) {
                if ((Math.abs(positionX - ship.getPositionX()) <= fireRangeX) && (Math.abs(positionY - ship.getPositionY()) <= fireRangeY)) {
                    ship.receiveDamage(damage);
                    break;
                }
            }
        }
    }

    //Metoda dzięki któej dany statek przyjmuje obrażenia zadane mu przez przeciwnika i jeżeli hp<=0 to przestaje istnieć
    public void receiveDamage(int damage)
    {
        if (hp > 0) {
            hp = hp - damage;
        }
        if (hp <= 0) {
            isAlive = false;
        }
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

    public void setAlive(boolean alive) {
        isAlive = alive;
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

    public boolean isAlive() {
        return isAlive;
    }
}
