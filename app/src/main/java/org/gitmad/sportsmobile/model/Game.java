package org.gitmad.sportsmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds information for a game.
 * Created by Andre Giron on 9/6/14.
 */
public class Game implements Parcelable {

    private int homeScore;
    private int awayScore;

    private final int quarter; // Current quarter that the game is in.
    private final int minutesLeft; // How many minutes left in the quarter
    private final int secondsLeft;

    private final Team homeTeam;
    private final Team awayTeam;

    public Game(final Team homeTeam, final Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.quarter = 1;
        this.minutesLeft = 15;
        this.secondsLeft = 0;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    private Game(final Team homeTeam, final Team awayTeam,
                 final int homeScore, final int awayScore,
                 final int quarter, final int minutesLeft, final int secondsLeft) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.quarter = quarter;
        this.minutesLeft = minutesLeft;
        this.secondsLeft = secondsLeft;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(homeScore);
        out.writeInt(awayScore);
        out.writeInt(quarter);
        out.writeInt(minutesLeft);
        out.writeInt(secondsLeft);
        out.writeSerializable(homeTeam);
        out.writeSerializable(awayTeam);
    }

    public static final Parcelable.Creator<Game> CREATOR
            = new Parcelable.Creator<Game>() {
        public Game createFromParcel(Parcel in) {
            final int homeScore = in.readInt();
            final int awayScore = in.readInt();
            final int quarter = in.readInt();
            final int minutesLeft = in.readInt();
            final int secondsLeft = in.readInt();
            final Team homeTeam = (Team) in.readSerializable();
            final Team awayTeam = (Team) in.readSerializable();
            return new Game(homeTeam, awayTeam,
                    homeScore, awayScore,
                    quarter, minutesLeft, secondsLeft);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
