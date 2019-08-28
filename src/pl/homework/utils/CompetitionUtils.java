package pl.homework.utils;

import pl.homework.lib.InvalidPlayerData;
import pl.homework.lib.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static pl.homework.app.Competition.CSV_FILE;
import static pl.homework.app.Competition.players;

public class CompetitionUtils {

    public static void readPlayersScores() {
        Player player;
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wynik zawodnika (lub wpisz stop)");
        String line = "";
        while (!(line = sc.nextLine()).equals("stop")) {
            String[] array = line.split(" ");
            try {
                players.add(checkData(array));
            } catch (NumberFormatException ex) {
                System.out.println("Błędny format wyniku zawodnika. " + ex.getMessage());
            } catch (InvalidPlayerData ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Podaj wynik kolejnego zawodnika (lub wpisz stop)");
        }
    }

    public static void savePlayerScores(List<Player> list) throws IOException {
        File file = new File(CSV_FILE);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (Player player: list) {
            bufferedWriter.write(player.toCSV());
        }
        bufferedWriter.close();
    }

    private static Player checkData(String[] array) throws InvalidPlayerData {
        String name = "";
        int score = 0;
        if (array.length > 2) {
                score = Integer.parseInt(array[array.length-1]);
                for (int i = 0; i < array.length-1; i++) {
                    name += array[i] + (i < array.length-2 ? " " : "");
                }
        } else
            throw new InvalidPlayerData();
        return new Player(name, score);
    }
}
