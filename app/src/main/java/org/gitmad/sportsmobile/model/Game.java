package org.gitmad.sportsmobile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds information associated with a score for a game.
 * Created by Andre Giron on 9/6/14.
 */
public class Game {

    private int homeScore;
    private int awayScore;

    private final int quarter; // Current quarter that the game is in.
    private final int minutesLeft; // How many minutes left in the quarter
    private final int secondsLeft;

    private final Team homeTeam;
    private final Team awayTeam;

    public Game(Team homeTeam, Team awayTeam) {
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

    public List<Team> getTeamList() {
        List<Team> teamList = new ArrayList<Team>(2);
        teamList.add(homeTeam);
        teamList.add(awayTeam);
        return teamList;
    }
}
