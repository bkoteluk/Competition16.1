package pl.homework.app;

import pl.homework.lib.Player;
import pl.homework.lib.ScoreComparator;
import pl.homework.utils.CompetitionUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Competition {
    public static final String CSV_FILE = "stats.csv";
    public static List<Player> players = new LinkedList<>();;

    public static void main(String[] args) {
        CompetitionUtils games = new CompetitionUtils();
        games.readPlayersScores();
        System.out.println(players);
        ScoreComparator scoreComparator = new ScoreComparator();
        Collections.sort(players, scoreComparator);
        System.out.println(players);
        try {
            games.savePlayerScores(players);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
