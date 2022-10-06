package com.Program2;

import java.util.Arrays;
import java.util.Random;

public class Dice {
    public int[] fiveDice;
    public int size = 5;
    public boolean noGoodrolls = true;

    public static int numbYahtzees;
    public static int numbFullhouse;
    public static int numbFourofakind;
    public static int numbLargestraight;
    public static int numbThreeofakind;
    public static int numbLosses;

    public Dice(){
        Random rand = new Random();
        fiveDice = new int[size];
        for(int i=0; i<size; i++){
            fiveDice[i]= rand.nextInt(6)+1;
        }
    }

    public void Yahtzee(){
        int count = 0;
        for(int i=0; i<size; i++){
            if(fiveDice[0] == fiveDice[i]){
                count++;
            }
        }
        if (count == 5){
            noGoodrolls = false;
            numbYahtzees++;
        }
    }

    public void Fullhouse(){
        int countFirstPairs = 0;
        int countSecondPairs = 0;
        int newNumb = 0;
        Arrays.sort(fiveDice);
        for(int i=0; i<size; i++){
            if(fiveDice[0] == fiveDice[i]){
                countFirstPairs++;
            }
            else if(fiveDice[0] != fiveDice[i]){
                newNumb = fiveDice[i];
            }
        }
        for(int i=0; i<size; i++){
            if(newNumb == fiveDice[i]){
                countSecondPairs++;
            }
        }
        if(countFirstPairs == 3 && countSecondPairs == 2 || countFirstPairs == 2 && countSecondPairs == 3){
            noGoodrolls = false;
            numbFullhouse++;
        }
    }

    public void Largestraight(){
        int countStraight = 0;
        for(int i=0; i<size; i++){
            if(fiveDice[0] == 1) {
                if (fiveDice[i] == (i + 1)) {
                    countStraight++;
                }
            }
            else if(fiveDice[0] == 2) {
                if (fiveDice[i] == (i + 2)) {
                    countStraight++;
                }
            }
        }
        if(countStraight == 5){
            noGoodrolls = false;
            numbLargestraight++;
        }

    }

    public void Fourofakind(){
        int firstCount = 0;
        int secondCount = 0;
        int newNumb = 0;
        for(int i=0; i<size; i++){
            if(fiveDice[0] == fiveDice[i]){
                firstCount++;
            }
            else if(fiveDice[0] != fiveDice[i]){
                newNumb = fiveDice[i];
            }
        }
        for(int i=0; i<size; i++) {
            if(newNumb == fiveDice[i]){
                secondCount++;
            }
        }
        if(firstCount == 1 && secondCount == 4 || firstCount == 4 && secondCount == 1){
            noGoodrolls = false;
            numbFourofakind++;
        }
    }

    public void Threeofakind(){
        int countThree = 0;
        for(int i=0; i<size; i++) {
            if (fiveDice[0] == fiveDice[i]) {
                countThree++;
            }
        }
        for(int i=0; i<size; i++) {
            if (fiveDice[1] == fiveDice[i]) {
                countThree++;
            }
        }
        for(int i=0; i<size; i++) {
            if (fiveDice[2] == fiveDice[i]) {
                countThree++;
            }
        }
        for(int i=0; i<size; i++) {
            if (fiveDice[3] == fiveDice[i]) {
                countThree++;
            }
        }
        for(int i=0; i<size; i++){
            if(fiveDice[4] == fiveDice[i]){
                countThree++;
            }
        }
        if(countThree == 11){
            noGoodrolls = false;
            numbThreeofakind++;
        }

    }

    public void Losers()
    {
        if(noGoodrolls == true){
            numbLosses++;
        }
    }

    public void Total(){
        System.out.println("Number of Yahtzees: " + numbYahtzees);
        System.out.println("Yahtzee Percent: " + String.format("%.2f",((double) numbYahtzees /5000) * 100) + "%");

        System.out.println();
        System.out.println("Number of Full Houses: " + numbFullhouse);
        System.out.println("Full House Percent: " + String.format("%.2f",((double) numbFullhouse /5000) * 100) + "%");

        System.out.println();
        System.out.println("Number of Large Straights: " + numbLargestraight);
        System.out.println("Large Straight Percentage: " + String.format("%.2f",((double) numbLargestraight /5000) * 100) + "%");

        System.out.println();
        System.out.println("Number of Four of a Kinds: " + numbFourofakind);
        System.out.println("Four of a Kind Percentage: " + String.format("%.2f",((double) numbFourofakind /5000) * 100) + "%");

        System.out.println();
        System.out.println("Number of Three of a Kinds: " + numbThreeofakind);
        System.out.println("Three of a Kind Percentage: " + String.format("%.2f",((double) numbThreeofakind /5000) * 100) + "%");

        System.out.println();
        System.out.println("Number of Losses: " + numbLosses);
        System.out.println("Losses Percentage: " + String.format("%.2f",((double) numbLosses /5000) * 100) + "%");
    }
}
