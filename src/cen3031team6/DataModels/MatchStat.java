package cen3031team6.DataModels;

public class MatchStat {

  public MatchStat() {

  }
  public MatchStat(String opponent, int userScore, int opponentScore) {
    this.opponent = opponent;

    if(userScore > opponentScore)
      winOrLoss = 'W';
    else
      winOrLoss = 'L';

    this.userScore = userScore;
    this.opponentScore = opponentScore;
  }

  private String opponent;

  private char winOrLoss;

  private int userScore;

  private int opponentScore;


  public String getOpponent() {
    return opponent;
  }

  public void setOpponent(String opponent) {
    this.opponent = opponent;
  }

  public char getWinOrLoss() {
    return winOrLoss;
  }

  public void setWinOrLoss(char winOrLoss) {
    this.winOrLoss = winOrLoss;
  }

  public int getUserScore() {
    return userScore;
  }

  public void setUserScore(int userScore) {
    this.userScore = userScore;
  }

  public int getOpponentScore() {
    return opponentScore;
  }

  public void setOpponentScore(int opponentScore) {
    this.opponentScore = opponentScore;
  }
}
