package cen3031team6.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Alex Thieler - The DbUtils class is used to create the databases and provide
 * access to databases
 */
public class DbUtils {

  // USER table.
  public static final String USER_TABLE_NAME = "USER";
  public static final String USER_ID = "ID";
  public static final String USER_NAME = "NAME";
  public static final String USER_PASSWORD = "PASSWORD";
  public static final String USER_IS_ADMIN = "IS_ADMIN";

  // ONEVONE_STATS table
  public static final String ONEVONE_STATS_TABLE_NAME = "ONEVONE_STATS";
  public static final String ONEVONE_STATS_PLAYER_ONE = "PLAYERONE";
  public static final String ONEVONE_STATS_PLAYER_TWO = "PLAYERTWO";
  public static final String ONEVONE_STATS_PLAYER_ONE_SCORE = "PLAYERONE_SCORE";
  public static final String ONEVONE_STATS_PLAYER_TWO_SCORE = "PLAYERTWO_SCORE";
  public static final String ONEVONE_STATS_DATE = "DATE";

  // TOURNAMENT table
  public static final String TOURNAMENT_TABLE_NAME = "TOURNAMENT";
  public static final String TOURNAMENT_ID = "ID";
  public static final String TOURNAMENT_NAME = "NAME";
  public static final String TOURNAMENT_START_DATE = "START_DATE";
  public static final String TOURNAMENT_START_TIME = "START_TIME";

  //TOURN_STAT table
  public static final String TOURN_STAT_TABLE_NAME = "TOURN_STAT";
  public static final String TOURN_STAT_PLAYER_ONE_NAME = " PLAYERONE";
  public static final String TOURN_STAT_PLAYER_TWO_NAME = "PLAYERTWO";
  public static final String TOURN_STAT_PLAYER_ONE_SCORE = "PLAYERONE_SCORE";
  public static final String TOURN_STAT_PLAYER_TWO_SCORE = "PLAYERTWO_SCORE";
  public static final String TOURN_STAT_DATE = "DATE";
  public static final String TOURN_STAT_TOURN_ID = "TOURN_ID";

  private static Database db;

  public static Database getDb() {
    if (db == null) {
      db = new Database();
    }
    return db;
  }

  public static class Database {

    private Connection conn;

    private Statement stmt;

    public Database() {
      final String JDBC_DRIVER = "org.h2.Driver";
      final String DB_URL = "jdbc:h2:./res/pongdb";

      final String USER = "";
      final String PASS = "";

      try {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    public Connection getConn() {
      try {
        if (conn == null || conn.isClosed()) {
          final String JDBC_DRIVER = "org.h2.Driver";
          final String DB_URL = "jdbc:h2:./res/pongdb";

          final String USER = "";
          final String PASS = "";

          conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
      } catch (SQLException e) {
        System.out.println("Failed to create connection: " + e.getMessage());
      }
      return conn;
    }

    public Statement getStmt() {
      try {
        if (stmt == null || stmt.isClosed()) {
          stmt = getConn().createStatement();
        }
      } catch (SQLException e) {
        System.out.println("Failed to create statement: " + e.getMessage());
      }
      return stmt;
    }

  }

}