package org.leetcode_problems.passpillow;

public class PassPillowMain {

    public static void main(String[] args) {

        // number of people in the line
        int n = 3;

        // number of seconds
        int time = 2;

        getindexValue(n, time);

    }


    public static void getindexValue(int n, int time) {

        // number of hoops
        int hoops = n - 1;

        int roundsCompleted = time/hoops;
        int extraHopOnLastRound = time % hoops;
        int returnValue = 0;


        System.out.println("Rounds Completed: " + roundsCompleted);
        System.out.println("Hops to complete on the last round: " + extraHopOnLastRound);

        // if rounds completed is even then the next round will start from the far left
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        if( roundsCompleted%2 == 0 ) {
            System.out.println("Rounds completed is even, hence the hop should start from the left"  );
            returnValue = extraHopOnLastRound -1;
            System.out.println("index: "  + ( returnValue ) );
        }
        // if rounds completed is odd then the next round will start from the far right
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        else {
            returnValue = n - extraHopOnLastRound;
            System.out.println("index: " + ( n - returnValue ) );
        }

    }
}
