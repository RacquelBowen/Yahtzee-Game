
//Racquel Miller
//CSCI - 132
//2/20/2022
//Program 2: Yahtzee in Java

package com.Program2;

public class Yahtzee {

    public static void main(String [] args) {
        int numbOfRolls = 5000;

        for(int i=0; i<numbOfRolls; i++) {
            Dice displayDicei = new Dice();
                displayDicei.Yahtzee();
                displayDicei.Fullhouse();
                displayDicei.Largestraight();
                displayDicei.Fourofakind();
                displayDicei.Threeofakind();
                displayDicei.Losers();
            if(i ==(numbOfRolls-1)) {
                System.out.println("Number of Rolls: " + numbOfRolls);
                System.out.println("-------------------------------");
                displayDicei.Total();
            }

        }
    }
}
