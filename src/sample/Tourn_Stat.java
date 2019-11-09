package sample;


public class Tourn_Stat {
  private User player1;
  private User player2;
  private int p1score;
  private int p2score;
  private long date;
  private int tourn_id;


  public User getPlayer1() {
    return player1;
  }

  public void setPlayer1(User player1) {
    this.player1 = player1;
  }

  public User getPlayer2() {
    return player2;
  }

  public void setPlayer2(User player2) {
    this.player2 = player2;
  }

  public int getP1score() {
    return p1score;
  }

  public void setP1score(int p1score) {
    this.p1score = p1score;
  }

  public int getP2score() {
    return p2score;
  }

  public void setP2score(int p2score) {
    this.p2score = p2score;
  }

  public long getDate() {
    return date;
  }

  public void setDate(long date) {
    this.date = date;
  }

  public int getTourn_id() {
    return tourn_id;
  }

  public void setTourn_id(int tourn_id) {
    this.tourn_id = tourn_id;
  }


}