package sample;

import java.util.Date;

/**
 * The Tournament class holds information about each object of this type.
 *
 * The Tournament class is used to populate a TableView of type Tournament, and the fields
 * are added to the respective columns within the table.
 */
public class Tournament {

  private String tournamentName;
  private Date startDate;
  private String startTime;
  private Tourn_Stat[] stats;

  /**
   * This constructor sets the fields when a Tournament object is built.
   *
   * @param name - Tournament name
   * @param startDate - Tournament start date
   * @param startTime - Tournament start time
   */
  public Tournament(String name, Date startDate, String startTime) {

    this.tournamentName = name;
    this.startDate = startDate;
    this.startTime = startTime;
  }

  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public Tourn_Stat[] getStats() {
    return stats;
  }

  public void setStats(Tourn_Stat[] stats) {
    this.stats = stats;
  }
}
