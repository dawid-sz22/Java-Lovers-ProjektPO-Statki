package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Simulation {

    private SeaCreator balticCreator = null;


    private int tryInput(String information)
    {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(information);
                if (scan.hasNextInt())
                {
                    return scan.nextInt();
                }
                else
                {
                    scan.nextLine();
                    System.out.print("Podano złe wejście! Spróbuj ponownie: ");
                }
        }
    }

    private boolean checkBalticIsInitialised()
    {
        if (balticCreator == null) {
            System.out.println("Nie utworzono mapy!");
            return false;
        }
        else return true;
    }

    public void start() {
        int firstStart=0,NumberOfIterations=0;
        while (true) {
            switch (tryInput("1. Symulacja z pliku" + "\n2. Symulacja z komunikacją z użytkownikiem. "+"\nPodaj typ symulacji: ")) {
                case 1:
                {
                    final int countParameters = 10; //10 - liczba parametrów, potrzebnych do zrobienia symulacji
                    String fileName;
                    System.out.print("Podaj nazwę pliku, który chcesz wczytać: ");
                    Scanner scanner = new Scanner(System.in);
                    fileName = scanner.nextLine();

                    List<List<Integer>> listOfParameters = new ArrayList<>();
                    String s;
                    int n=0;
                    try (BufferedReader br = new BufferedReader(new FileReader("./Tests/"+fileName)))
                    {
                        while ((s = br.readLine()) != null)
                        {
                            List<String> listStringsFromeLine = Arrays.asList(s.split(";")); //zapisz do listy stringi, oddzielone średnikiem
                            List<Integer> intList = new ArrayList<>();
                            for (String x: listStringsFromeLine) { //robienie listy parametrów
                                intList.add(Integer.valueOf(x));
                            }
                            if (intList.size() == countParameters)
                                listOfParameters.add(intList);  //dodanie listy parametrów, do spisu list z parametrami
                            else
                                System.out.println("PODANO ZŁĄ ILOŚĆ PARAMETRÓW!");
                        }
                    }
                    catch (IOException e) {
                        System.out.println("Nie znaleziono pliku");
                    }

                    for (int i = 0; i < listOfParameters.size(); i++) {
                        int j = 0;
                        balticCreator = new SeaCreator(listOfParameters.get(i).get(j++),listOfParameters.get(i).get(j++),listOfParameters.get(i).get(j++),listOfParameters.get(i).get(j++),
                                listOfParameters.get(i).get(j++),listOfParameters.get(i).get(j++),listOfParameters.get(i).get(j++),listOfParameters.get(i).get(j++));
                        balticCreator.stage(listOfParameters.get(i).get(j++),0,listOfParameters.get(i).get(j),fileName);
                    }

                    break;
                }
                case 2:
                {
                    while (true) {
                        printMenu();
                        //scan.nextLine();
                        switch (tryInput("Podaj opcję, którą chcesz wybrać: ")) {
                            case 1: {
                                balticCreator = new SeaCreator(tryInput("Podaj wymiar x: "), tryInput("Podaj wymiar y: "),
                                        tryInput("\nRED SIDE:\nPodaj liczbe lotniskowców: "), tryInput("Podaj liczbe okrętów wodnych: "), tryInput("Podaj liczbe krążowników: "),
                                        tryInput("\nBLUE SIDE:\nPodaj liczbe lotniskowców: "), tryInput("Podaj liczbe okrętów wodnych: "), tryInput("Podaj liczbe krążowników: "));
                                System.out.println("Mapa została utworzona!");
                                break;
                            }
                            case 2: {
                                if (checkBalticIsInitialised()) balticCreator.printSea();
                                System.out.println();
                                break;
                            }
                            case 3: {
                                if (checkBalticIsInitialised()) balticCreator.seeHp();
                                System.out.println();
                                break;
                            }
                            case 4: {
                                if (checkBalticIsInitialised()) {
                                    firstStart = tryInput("Podaj kto ma ruszać się pierwszy (1 - RED , 2 - BLUE):");
                                    NumberOfIterations = tryInput("Podaj liczbę rund: ");
                                    System.out.println("0. Wykonaj całą symulacje, na sam koniec zapisz statystki do pliku");
                                    System.out.println("1. Wykonaj całą symulacje, na sam koniec wyświetl mapę,listę statków oraz statystki");
                                    System.out.println("2. Wykonaj całą symulacje, z zatrzymywaniem się co rundę");
                                    switch (tryInput("Podaj opcję, którą chcesz wybrać: ")) {
                                        case 0 -> balticCreator.stage(firstStart, 0, NumberOfIterations);
                                        case 1 -> balticCreator.stage(firstStart, 1, NumberOfIterations);
                                        case 2 -> balticCreator.stage(firstStart, 2, NumberOfIterations);
                                        default -> System.out.println("Podano złą liczbę! Spróbuj ponownie");
                                    }
                                }
                                break;
                            }
                            case 0:
                                return;
                            default:
                                System.out.println("Podano złą liczbę! Spróbuj ponownie");
                        }
                    }
                }
                default:
                    System.out.println("Podano złą liczbę! Spróbuj ponownie");
            }
        }
    }

    public void printMenu()
    {
        System.out.println("Symulacja STATKI");
        System.out.println("1. Stwórz mapę oraz dodaj jednostki");
        System.out.println("2. Wyświetl mapę");
        System.out.println("3. Wyświetl listę jednostek obu drużyn");
        System.out.println("4. Rozpocznij symulacje");
        System.out.println("0. Zakończ symulacje");
        System.out.print("Podaj opcję którą chcesz wybrać: ");
    }
}
