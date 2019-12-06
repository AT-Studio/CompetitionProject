package cen3031team6.DataModels;

import java.util.Date;

/**
 * The TournamentPkg class holds information about each object of this type.
 *
 * The TournamentPkg class is used to populate a TableView of type TournamentPkg, and the fields are
 * added to the respective columns within the table.
 */
public class Tournament {

  private int id;
  private String tournamentName;
  private String startDate;
  private String startTime;
  private Tourn_Stat[] stats;

  /**
   * This constructor sets the fields when a TournamentPkg object is built.
   *
   * @param name - TournamentPkg name
   * @param startDate - TournamentPkg start date
   * @param startTime - TournamentPkg start time
   */
  public Tournament(String name, String startDate, String startTime) {
    this.tournamentName = name;
    this.startDate = startDate;
    this.startTime = startTime;
  }

  public Tournament(int id, String name, String startDate, String startTime) {
    this.id = id;
    this.tournamentName = name;
    this.startDate = startDate;
    this.startTime = startTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
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
