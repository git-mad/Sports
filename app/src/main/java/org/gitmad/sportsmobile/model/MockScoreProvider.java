package org.gitmad.sportsmobile.model;

import android.graphics.Color;

import org.gitmad.sportsmobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre Giron on 9/6/14.
 * Class to Mock Scores before we implement net code.
 */
public class MockScoreProvider {

    private final ArrayList<Team> afcNorth;
    private final ArrayList<Team> afcSouth;
    private final ArrayList<Team> afcEast;

    // TODO: Add these conferences later.
    //private ArrayList<Team> afcWest = new ArrayList<Team>();
    //private ArrayList<Team> nfcNorth = new ArrayList<Team>();
    //private ArrayList<Team> nfcSouth = new ArrayList<Team>();
    //private ArrayList<Team> nfcEast = new ArrayList<Team>();
    //private ArrayList<Team> nfcWest = new ArrayList<Team>();

    private final ArrayList<Game> scores;

    public MockScoreProvider() {
        //public Team(String long_name, String short_name, String conference, String homeTown)
        Team ravens = new Team("Baltimore Ravens", "BAL", "AFC North", "Baltimore, MD",
                Color.parseColor("#141F94"));
        ravens.setImageId(R.drawable.ravens);
        Team bengals = new Team("Cincinnati Bengals", "CIN", "AFC North", "Cincinatti, OH",
                Color.parseColor("#F04D22"));
        bengals.setImageId(R.drawable.bengals);
        Team browns = new Team("Cleveland Browns", "CLE", "AFC North", "Cleveland, OH",
                Color.parseColor("#E24E05"));
        browns.setImageId(R.drawable.browns);
        Team steelers = new Team("Pittsburgh Steelers", "PIT", "AFC North", "Pittsburgh, PA",
                Color.parseColor("#FBA000"));
        steelers.setImageId(R.drawable.steelers);
        afcNorth = new ArrayList<Team>();
        afcNorth.add(ravens);
        afcNorth.add(bengals);
        afcNorth.add(browns);
        afcNorth.add(steelers);

        Team texans = new Team("Houston Texans", "HOU", "AFC Sorth", "Houston, TX",
                Color.parseColor("#06192E"));
        texans.setImageId(R.drawable.texans);
        Team colts = new Team("Indianapolis Colts", "IND", "AFCSouth", "Indianapolis, IN",
                Color.parseColor("#023C76"));
        colts.setImageId(R.drawable.colts);
        Team jaguars = new Team("Jacksonville Jaguars", "JAX", "AFC South", "Jacksonville, FL",
                Color.parseColor("#0F445D"));
        jaguars.setImageId(R.drawable.jaguars);
        Team titans = new Team("Tennessee Titans", "TEN", "AFC South", "Nashville, TN",
                Color.parseColor("#00265A"));
        titans.setImageId(R.drawable.titans);
        afcSouth = new ArrayList<Team>();
        afcSouth.add(texans);
        afcSouth.add(colts);
        afcSouth.add(jaguars);
        afcSouth.add(titans);

        Team bills = new Team("Buffalo Bills", "BUF", "AFC East", "Buffalo, NY",
                Color.parseColor("#194787"));
        bills.setImageId(R.drawable.bills);
        Team dolphins = new Team("Miami Dolphins", "MIA", "AFC East", "Miami,FL",
                Color.parseColor("#0B7B7C"));
        dolphins.setImageId(R.drawable.dolphins);
        Team patriots = new Team("New England Patriots", "NE", "AFC East", "Foxborough, MA",
                Color.parseColor("#113E90"));
        patriots.setImageId(R.drawable.patriots);
        Team jets = new Team("New York Jets", "NYJ", "AFC East", "East Rutherford, NY",
                Color.parseColor("#15684C"));
        jets.setImageId(R.drawable.jets);
        afcEast = new ArrayList<Team>();
        afcEast.add(bills);
        afcEast.add(dolphins);
        afcEast.add(patriots);
        afcEast.add(jets);

        //etc. for the rest of the NFL conferences.

        //Make some score objects
        Game game0 = new Game(texans, colts);
        game0.setHomeScore(6);
        game0.setAwayScore(28);

        Game game1 = new Game(patriots, jets);
        game1.setHomeScore(7);
        game1.setAwayScore(14);

        Game game2 = new Game(ravens, bengals);
        game2.setHomeScore(21);
        game2.setAwayScore(14);

        Game game3 = new Game(texans, colts);
        game3.setHomeScore(6);
        game3.setAwayScore(28);

        Game game4 = new Game(browns, steelers);
        game4.setHomeScore(6);
        game4.setAwayScore(28);

        Game game5 = new Game(jets, bills);
        game5.setHomeScore(6);
        game5.setAwayScore(28);

        Game game6 = new Game(bengals, patriots);
        game6.setHomeScore(6);
        game6.setAwayScore(28);

        Game game7 = new Game(titans, jaguars);
        game7.setHomeScore(6);
        game7.setAwayScore(28);

        Game game8 = new Game(bills, dolphins);
        game8.setHomeScore(6);
        game8.setAwayScore(28);

        Game game9 = new Game(ravens, browns);
        game9.setHomeScore(60);
        game9.setAwayScore(2899);

        scores = new ArrayList<Game>(10);
        scores.add(game0);
        scores.add(game1);
        scores.add(game2);
        scores.add(game3);
        scores.add(game4);
        scores.add(game5);
        scores.add(game6);
        scores.add(game7);
        scores.add(game8);
        scores.add(game9);
    }

    public List<Game> getGameList() {
        return scores;
    }

}
