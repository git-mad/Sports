package org.gitmad.sportsmobile.model;

import android.content.Context;
import android.graphics.Color;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.db.GamesDataSource;
import org.gitmad.sportsmobile.db.TeamsDataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre Giron on 9/6/14.
 * Class to Mock Scores before we implement net code.
 */
public class MockScoreProvider {

    TeamsDataSource teamDS;
    GamesDataSource gameDS;
    public MockScoreProvider(Context context) {

        teamDS = new TeamsDataSource(context);
        gameDS = new GamesDataSource(context);


    }

    public List<Game> getGameList() {
        try
        {
            gameDS.open();
            List<Game> games = gameDS.getAllGames();
            gameDS.close();
            return games;
        }
        catch(SQLException sqlex)
        {
            return null;
        }
    }


    public List<Team> getConference(String conference)
    {
        try {
            teamDS.open();
            List<Team> teams = teamDS.getConference(conference);
            teamDS.close();
            return teams;
        }
        catch(SQLException sqlex)
        {
            return null;
        }
    }
    public List<Team> getTeamList() {
        try {
            teamDS.open();
            List<Team> teams = teamDS.getAllTeams();
            teamDS.close();
            return teams;
        }
        catch(SQLException sqlex)
        {
            return null;
        }
    }

    public Game addGame(Team team, Team team1, int i, int i1, int i2, int i3, int i4) {
        try
        {
            gameDS.open();
            Game game = gameDS.addGame(team, team1, i, i1, i2, i3, i4);
            gameDS.close();
            return game;
        }
        catch (SQLException sqlex)
        {
            return null;
        }
    }
}
