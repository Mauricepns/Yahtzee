package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        YahtzeeSpel Yahtzee = new YahtzeeSpel();
        Yahtzee.Spelen();

    }
}

class YahtzeeSpel {

    boolean game = true;
    String stoppen = "q";
    int aantalWorpen = 1;

    void Spelen() {

        while (game) {

            System.out.println("Druk enter om te spelen, of q om te stoppen");
            Scanner scanner = new Scanner(System.in);
            String invoer = scanner.nextLine().toLowerCase();
            Dobbelsteen dobbelsteen = new Dobbelsteen();
            Random reroll = new Random();


            if (invoer.matches("q")) {
                game = false;
                System.out.println("Bedankt voor het spelen");
            } else {

                ArrayList<Integer> worp = Dobbelsteen.werpen();

                while (game) {

                    System.out.println("Je hebt gegooid... " + worp);
                    System.out.println("Welke je stenen hergooien? 1,2,3,4 en/of 5?");
                    String invoer2 = scanner.nextLine().toLowerCase();

                    if (invoer2.equals("q")) {
                        game = false;
                        System.out.println("Bedankt voor het spelen");
                    } else {
                        Dobbelsteen.reroll(worp, invoer2);
                        aantalWorpen++;
                        if (aantalWorpen == 3) {
                            System.out.println("Je hebt 3 keer gegooid!");
                            System.out.println("Jouw uitkomst is " + worp);
                            System.out.println("Bedankt voor het spelen");
                            System.out.println("===========");
                            game = false;
                        }
                    }
                }
            }
        }
    }
}

class Dobbelsteen {

    static ArrayList<Integer> werpen() {
        ArrayList<Integer> getallenArray = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int getal = r.nextInt(6) + 1;
            getallenArray.add(getal);
        }
        return getallenArray;
    }

    public static void reroll(ArrayList<Integer> worp, String invoer2) {
        Random reroll = new Random();

        if (invoer2.contains("1")) {
            worp.set(0, reroll.nextInt(6) + 1);
        }
        if (invoer2.contains("2")) {
            worp.set(1, reroll.nextInt(6) + 1);
        }
        if (invoer2.contains("3")) {
            worp.set(2, reroll.nextInt(6) + 1);
        }
        if (invoer2.contains("4")) {
            worp.set(3, reroll.nextInt(6) + 1);
        }
        if (invoer2.contains("5")) {
            worp.set(4, reroll.nextInt(6) + 1);
        }
    }
}

