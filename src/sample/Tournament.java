package sample;

import java.util.Date;

public class Tournament {

  private String tournamentName = null;
  private Date startDate = null;
  private String startTime = null;
  private Tourn_Stat[] stats;


  public Tournament(String name, Date startDate, String startTime){

    this.tournamentName = name;
    this.startDate = startDate;
    this.startTime = startTime;
  }
}
