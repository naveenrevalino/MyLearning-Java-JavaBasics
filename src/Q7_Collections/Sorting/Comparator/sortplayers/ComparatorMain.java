package Q7_Collections.Sorting.Comparator.sortplayers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) {

        // Method Variables
        List<Player> listOfPlayers = new ArrayList<>();

        // Add players to the list
        listOfPlayers.add( new Player( "Smith", 20 ));
        listOfPlayers.add( new Player( "Jones", 15 ));
        listOfPlayers.add( new Player( "Jones", 20 ));

        // Initialize Checker
        Comparator<Player> playerComparator = new Checker();

        // Perform the compare on the collection
        Collections.sort( listOfPlayers, playerComparator );

        // Print the sorted list
        for ( Player eachPlayer : listOfPlayers )
            System.out.println( eachPlayer.playerName + "  " + eachPlayer.playerRanking );

    }
}
