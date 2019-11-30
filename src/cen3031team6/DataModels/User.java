package cen3031team6.DataModels;

/**
 * The User class is the data model for each user and holds all of the user's statistics, and
 * methods to operate on this data.
 *
 * @author Austin Nolz - The User class holds statistics for 1v1 and tournament matches, username,
 * password, match history, and methods to access all of this data.
 *
 */
public class User {

  private String username;

  public User(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
