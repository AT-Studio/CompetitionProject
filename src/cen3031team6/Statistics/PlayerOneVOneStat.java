package cen3031team6.Statistics;

public class PlayerOneVOneStat {

    private String name;
    private int wins;
    private int losses;
    private int ties;
    private int score;

    public PlayerOneVOneStat(String name) {
        this.name = name;
    }

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
