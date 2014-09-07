package org.gitmad.sportsmobile;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Andre Giron on 9/6/14.
 * Class to Mock Scores before we implement net code.
 */
public class MockScoreProvider {

    private ArrayList<Team> afcNorth;
    private ArrayList<Team> afcSouth;
    private ArrayList<Team> afcEast;

    //TODO: Add these conferences later.
    //private ArrayList<Team> afcWest = new ArrayList<Team>();
    //private ArrayList<Team> nfcNorth = new ArrayList<Team>();
    //private ArrayList<Team> nfcSouth = new ArrayList<Team>();
    //private ArrayList<Team> nfcEast = new ArrayList<Team>();
    //private ArrayList<Team> nfcWest = new ArrayList<Team>();

    private ArrayList<Score> scores;


    public MockScoreProvider()
    {
        //public Team(String long_name, String short_name, String conference, String homeTown)
        Team ravens = new Team("Baltimore Ravens", "BAL", "AFC North", "Baltimore, MD");
        Team bengals = new Team("Cincinnati Bengals", "CIN", "AFC North", "Cincinatti, OH");
        Team browns = new Team("Cleveland Browns", "CLE", "AFC North", "Cleveland, OH");
        Team steelers = new Team("Pittsburgh Steelers", "PIT", "AFC North", "Pittsburgh, PA");
        afcNorth = new ArrayList<Team>();
        afcNorth.add(ravens);
        afcNorth.add(bengals);
        afcNorth.add(browns);
        afcNorth.add(steelers);

        Team texans = new Team("Houston Texans", "HOU", "AFC Sorth", "Houston, TX");
        Team colts = new Team("Indianapolis Colts", "IND", "AFCSouth", "Indianapolis, IN");
        Team jaguars = new Team("Jacksonville Jaguars", "JAX", "AFC South", "Jacksonville, FL");
        Team titans = new Team("Tennessee Titans", "TEN", "AFC South", "Nashville, TN");
        afcSouth = new ArrayList<Team>();
        afcSouth.add(texans);
        afcSouth.add(colts);
        afcSouth.add(jaguars);
        afcSouth.add(titans);

        Team bills = new Team("Buffalo Bills", "BUF", "AFC East", "Buffalo, NY");
        Team dolphins = new Team("Miami Dolphins", "MIA", "AFC East", "Miami,FL");
        Team patriots = new Team("New England Patriots", "NE", "AFC East", "Foxborough, MA");
        Team jets = new Team("New York Jets", "NYJ", "AFC East", "East Rutherford, NY");
        afcEast = new ArrayList<Team>();
        afcEast.add(bills);
        afcEast.add(dolphins);
        afcEast.add(patriots);
        afcEast.add(jets);

        //etc. for the rest of the NFL conferences.

        //Make some score objects
        Score game1 = new Score(patriots,jets);
        game1.setHomeScore(7);
        game1.setAwayScore(14);

        Score game2 = new Score(ravens, bengals);
        game2.setHomeScore(21);
        game2.setAwayScore(14);

        Score game3 = new Score(texans,colts);
        game3.setHomeScore(6);
        game3.setAwayScore(28);

        scores = new ArrayList<Score>();
        scores.add(game1);
        scores.add(game2);
        scores.add(game3);
    }

    public ArrayList<Score> getCurrentScores()
    {
        return scores;
    }

}