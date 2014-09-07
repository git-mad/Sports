package org.gitmad.sportsmobile;

import java.util.ArrayList;

/**
 * Created by Andre Giron on 9/6/14.
 * Class to Mock Scores before we implement net code.
 */
public class MockScoreProvider {

    private ArrayList<Team> afcNorth = new ArrayList<Team>();
    private ArrayList<Team> afcSouth = new ArrayList<Team>();
    private ArrayList<Team> afcEast = new ArrayList<Team>();
    private ArrayList<Team> afcWest = new ArrayList<Team>();
    private ArrayList<Team> nfcNorth = new ArrayList<Team>();
    private ArrayList<Team> nfcSouth = new ArrayList<Team>();
    private ArrayList<Team> nfcEast = new ArrayList<Team>();
    private ArrayList<Team> nfcWest = new ArrayList<Team>();

    public MockScoreProvider()
    {
        //public Team(String long_name, String short_name, String conference, String homeTown)
        Team ravens = new Team("Baltimore Ravens", "BAL", "AFC North", "Baltimore, MD");
        Team bengals = new Team("Cincinnati Bengals", "CIN", "AFC North", "Cincinatti, OH");
        Team browns = new Team("Cleveland Browns", "CLE", "AFC North", "Cleveland, OH");
        Team steelers = new Team("Pittsburgh Steelers", "PIT", "AFC North", "Pittsburgh, PA");

        afcNorth.add(ravens);
        afcNorth.add(bengals);
        afcNorth.add(browns);
        afcNorth.add(steelers);

        Team texans = new Team("Houston Texans", "HOU", "AFC Sorth", "Houston, TX");
        Team colts = new Team("Indianapolis Colts", "IND", "AFCSouth", "Indianapolis, IN");
        Team jaguars = new Team("Jacksonville Jaguars", "JAX", "AFC South", "Jacksonville, FL");
        Team titans = new Team("Tennessee Titans", "TEN", "AFC South", "Nashville, TN");

        afcSouth.add(texans);
        afcSouth.add(colts);
        afcSouth.add(jaguars);
        afcSouth.add(titans);

        Team bills = new Team("Buffalo Bills", "BUF", "AFC East", "Buffalo, NY");
        Team dolphins = new Team("Miami Dolphins", "MIA", "AFC East", "Miami,FL");
        Team patriots = new Team("New England Patriots", "NE", "AFC East", "Foxborough, MA");
        Team jets = new Team("New York Jets", "NYJ", "AFC East", "East Rutherford, NY");
        afcEast.add(bills);
        afcEast.add(dolphins);
        afcEast.add(patriots);
        afcEast.add(jets);
    }

    public Score[] getCurrentScores()
    {
        //TODO: Return some mock scores.
        return null;
    }

}
