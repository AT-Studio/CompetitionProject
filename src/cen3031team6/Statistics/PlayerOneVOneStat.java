package cen3031team6.Statistics;

/**
 * @author Alex Theiler - The PlayerOneVOneStat
 */
public class PlayerOneVOneStat {

    private String name;
    private int wins;
    private int losses;
    private int ties;
    private int score;

    /**
     *
     * @param name
     */
    public PlayerOneVOneStat(String name) {
        this.name = name;
    }

    /**
     * The incrementWins() method increments wins and scores.
     */
    public void incrementWins() {
        wins++;
        score++;
    }

    public void incrementLosses() {
        losses++;
        score--;
    }

    public void incrementTies() {
        ties++;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getScore() {
        return score;
    }

}
