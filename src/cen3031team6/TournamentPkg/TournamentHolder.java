package cen3031team6.TournamentPkg;

/**
 * The TournamentHolder class is a  data model to store information from the
 * TournSelectionController and send to the TournDetailPageController.
 */
public class TournamentHolder {

  private String tournamentName;
  private String tournamentDate;
  private String tournamentStartTime;

  public String getTournamentName() {
    return tournamentName;
  }

  public void setTournamentName(String tournamentName) {
    this.tournamentName = tournamentName;
  }

  public String getTournamentDate() {
    return tournamentDate;
  }

  public void setTournamentDate(String tournamentDate) {
    this.tournamentDate = tournamentDate;
  }

  public String getTournamentStartTime() {
    return tournamentStartTime;
  }

  public void setTournamentStartTime(String tournamentStartTime) {
    this.tournamentStartTime = tournamentStartTime;
  }
}