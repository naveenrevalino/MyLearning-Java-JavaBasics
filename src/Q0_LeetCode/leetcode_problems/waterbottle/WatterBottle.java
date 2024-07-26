package org.leetcode_problems.waterbottle;

public class WatterBottle {
    public static void main(String[] args) {

        int numBottles = 15;
        int numExchange = 4;
        int quotient = numBottles/numExchange;
        int reminder = numBottles%numExchange;
        int howManyTimes = numExchange * quotient;
        int exchangeReminder = numExchange/quotient;
        int maxNumberOfBottleYouCanDrink = howManyTimes + quotient +  numExchange;

        System.out.println("quotient [a/b]: " + quotient);

        System.out.println("reminder [a%b] : " + reminder);

        System.out.println("Number of times : " + howManyTimes);

        System.out.println("max number of bottles : " + maxNumberOfBottleYouCanDrink);

        System.out.println( "exchange : " + exchangeReminder );


    }
}
