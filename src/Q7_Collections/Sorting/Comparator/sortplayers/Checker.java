package Q7_Collections.Sorting.Comparator.sortplayers;

import java.util.Comparator;

public class Checker implements Comparator<Player> {


    // Custom compare method
    public int compare(Player player1, Player player2) {


        if ( player1.playerRanking == player2.playerRanking ) {
            return player1.playerName.compareTo( player2.playerName );
        }

        return player1.playerRanking - player2.playerRanking;

    }
}
