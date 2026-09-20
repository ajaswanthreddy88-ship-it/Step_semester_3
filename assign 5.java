import java.util.Arrays;

class Player implements Comparable<Player> {

    // Encapsulation
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name,
                  int matchesPlayed,
                  double battingAverage,
                  boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded method 1
    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    // Overloaded method 2
    static boolean isDraftable(int matchesPlayed,
                                boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Compare players by batting average
    @Override
    public int compareTo(Player other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    // Draft and rank
    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        // Find draftable players
        for (Player player : players) {

            if (isDraftable(player.matchesPlayed) ||
                isDraftable(player.matchesPlayed,
                            player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        // Remove unused null positions
        Player[] finalList =
                Arrays.copyOf(draftable, count);

        // Sort using compareTo()
        Arrays.sort(finalList);

        // Create output
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].name);

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}

public class Main {

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        String result = Player.draftAndRank(players);

        System.out.println(result);
    }
}
