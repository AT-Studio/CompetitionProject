package sample;

import java.util.Date;

public class Tournament {

  private String tournamentName = null;
  private Date startDate = null;
  private String startTime = null;

  public Tournament(String name, Date startDate, String startTime){

    this.tournamentName = name;
    this.startDate = startDate;
    this.startTime = startTime;
  }
}
