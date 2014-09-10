package org.gitmad.sportsmobile;

/**
 * Holds information associated with a score for a game.
 * Created by Andre Giron on 9/6/14.
 */
public class Score {

    private int homeScore;
    private int awayScore;

    private int quarter; //Current quarter that the game is in.
    private int minutesLeft; //How many minutes left in the quarter
    private int secondsLeft;

    private Team homeTeam;
    private Team awayTeam;

    public Score(Team homeTeam, Team awayTeam)
    {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.quarter = 1;
        this.minutesLeft = 15;
        this.secondsLeft = 0;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public int getHomeScore()
    {
        return this.homeScore;
    }

    public void setHomeScore(int score)
    {
        this.homeScore = score;
    }

    public int getAwayScore()
    {
        return this.awayScore;
    }

    public void setAwayScore(int score)
    {
        this.awayScore = score;
    }

    public int getQuarter()
    {
        return this.quarter;
    }

    public int getMinutesLeft()
    {
        return this.minutesLeft;
    }

    public int getSecondsLeft()
    {
        return this.secondsLeft;
    }

    public Team getHomeTeam()
    {
        return this.homeTeam;
    }

    public Team getAwayTeam()
    {
        return this.awayTeam;
    }
}
