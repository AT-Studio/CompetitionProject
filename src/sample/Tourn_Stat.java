package sample;

public class Tourn_Stat {
  private int id;
  private int player1;
  private int player2;
  private int p1_score;
  private int p2_score;
  private long date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPlayer1() {
    return player1;
  }

  public void setPlayer1(int player1) {
    this.player1 = player1;
  }

  public int getPlayer2() {
    return player2;
  }

  public void setPlayer2(int player2) {
    this.player2 = player2;
  }

  public int getP1_score() {
    return p1_score;
  }

  public void setP1_score(int p1_score) {
    this.p1_score = p1_score;
  }

  public int getP2_score() {
    return p2_score;
  }

  public void setP2_score(int p2_score) {
    this.p2_score = p2_score;
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

  private int tourn_id;

}
