package org.gitmad.sportsmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Holds information for a game.
 */
public class Game implements Parcelable {

    private long id;

    private int homeScore;
    private int awayScore;

    private String clock;

    private final Team homeTeam;
    private final Team awayTeam;

    public Game(final Team homeTeam, final Team awayTeam,
                 final int homeScore, final int awayScore,
                 final String clock) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.clock = clock;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public long getId() {return id;}

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

    public String getClock()
    {
        return clock;
    }

    public Team getHomeTeam()
    {
        return this.homeTeam;
    }

    public Team getAwayTeam()
    {
        return this.awayTeam;
    }

    public Map<Team, Integer> getTeamScoreMap() {
        final Map<Team, Integer> teamScoreMap = new HashMap<Team, Integer>(2);
        teamScoreMap.put(homeTeam, homeScore);
        teamScoreMap.put(awayTeam, awayScore);
        return teamScoreMap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(homeScore);
        out.writeInt(awayScore);
        out.writeString(clock);
        out.writeSerializable(homeTeam);
        out.writeSerializable(awayTeam);
    }

    public static final Parcelable.Creator<Game> CREATOR
            = new Parcelable.Creator<Game>() {
        public Game createFromParcel(Parcel in) {
            final int homeScore = in.readInt();
            final int awayScore = in.readInt();
            final String clock = in.readString();
            final Team homeTeam = (Team) in.readSerializable();
            final Team awayTeam = (Team) in.readSerializable();
            return new Game(homeTeam, awayTeam,
                    homeScore, awayScore,
                    clock);
        }

        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
