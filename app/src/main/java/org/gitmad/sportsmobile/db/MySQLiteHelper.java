package org.gitmad.sportsmobile.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;

import org.gitmad.sportsmobile.R;

public class MySQLiteHelper extends SQLiteOpenHelper {


    /*private final String longName; //exe. Atlanta Falcons
    private final String shortName; //exe. ATL
    private final String conference; //exe. NFC South
    private final String homeTown;   //Atlanta
    private final int primaryColor;
    private int imageId; //exe R.id.falcons
    */

    public static final String TABLE_TEAMS = "teams";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LONGNAME = "long_name";
    public static final String COLUMN_SHORTNAME = "short_name";
    public static final String COLUMN_CONFERENCE = "conference";
    public static final String COLUMN_HOMETOWN = "hometown";
    public static final String COLUMN_COLOR = "primary_color";
    public static final String COLUMN_IMAGEID = "image_id";

    /*
    private int homeScore;
    private int awayScore;

    private final int quarter; // Current quarter that the game is in.
    private final int minutesLeft; // How many minutes left in the quarter
    private final int secondsLeft;

    private final Team homeTeam;
    private final Team awayTeam;
     */

    public static final String TABLE_GAMES = "games";
    public static final String COLUMN_HOME_SCORE = "home_score";
    public static final String COLUMN_AWAY_SCORE = "away_score";
    public static final String COLUMN_QUARTER = "quarter";
    public static final String COLUMN_MINUTES = "minutes";
    public static final String COLUMN_SECONDS = "seconds";
    public static final String COLUMN_HOME_ID = "home_team_id";
    public static final String COLUMN_AWAY_ID = "away_team_id";


    public static final String DATABASE_NAME = "teams.db";
    public static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_TEAMS + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LONGNAME + " text not null, "
            + COLUMN_SHORTNAME+ " text not null, "
            + COLUMN_CONFERENCE+ " text not null, "
            + COLUMN_HOMETOWN+ " text not null, "
            + COLUMN_COLOR+ " integer not null, "
            + COLUMN_IMAGEID+ " integer not null);";
    private static final String DATABASE_CREATE_GAMES =
            "create table "
            +TABLE_GAMES + "("
            + COLUMN_ID+ " integer primary key autoincrement, "
            + COLUMN_HOME_SCORE+" integer not null, "
            + COLUMN_AWAY_SCORE+" integer not null, "
            + COLUMN_QUARTER+" integer not null, "
            + COLUMN_MINUTES+"  integer not null, "
            + COLUMN_SECONDS+" integer not null, "
            + COLUMN_HOME_ID+" integer not null, "
            + COLUMN_AWAY_ID+" integer not null);";




    public MySQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
        sqLiteDatabase.execSQL(DATABASE_CREATE_GAMES);
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Baltimore Ravens\", \"BAL\", \"AFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.ravens+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Cleveland Browns\", \"CLE\", \"AFC NORTH\",\"Cleveland, OH\", "+ Color.parseColor("#E24E05")+", "+ R.drawable.browns+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Pittsburgh Steelers\", \"PIT\", \"AFC NORTH\",\"Pittsburgh, PA\", "+ Color.parseColor("#FBA000")+", "+ R.drawable.steelers+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Cincinatti Bengals\", \"CIN\", \"AFC NORTH\",\"Pittsburgh, PA\", "+ Color.parseColor("#FBA000")+", "+ R.drawable.bengals+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Houston Texans\", \"HOU\", \"AFC SOUTH\",\"Houston, TX\", "+ Color.parseColor("#06192E")+", "+ R.drawable.texans+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Indianapolis Colts\", \"IND\", \"AFC SOUTH\",\"Indianapolis, MD\", "+ Color.parseColor("#023C76")+", "+ R.drawable.colts+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Jacksonville Jaguars\", \"JAC\", \"AFC South\",\"Jacksonville, FL\", "+ Color.parseColor("#0F445D")+", "+ R.drawable.jaguars+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Tennessee Titans\", \"TEN\", \"AFC SOUTH\",\"Nashville, TN\", "+ Color.parseColor("#00265A")+", "+ R.drawable.titans+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Buffalo Bills\", \"BUF\", \"AFC EAST\",\"Buffalo, NY\", "+ Color.parseColor("#194787")+", "+ R.drawable.bills+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Miami Dolphins\", \"MIA\", \"AFC EAST\",\"Miami, FL\", "+ Color.parseColor("#0B7B7C")+", "+ R.drawable.dolphins+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"New England Patriots\", \"NE\", \"AFC EAST\",\"Foxborough, MA\", "+ Color.parseColor("#113E90")+", "+ R.drawable.patriots+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"New York Jets\", \"NYJ\", \"AFC EAST\",\"East Rutherford, NY\", "+ Color.parseColor("#15684C")+", "+ R.drawable.jets+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Denver Broncos\", \"DEN\", \"AFC WEST\",\"Denver, CO\", "+ Color.parseColor("#141F94")+", "+ R.drawable.broncos+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Kansas City Chiefs\", \"KC\", \"AFC WEST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.chiefs+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Oakland Raiders\", \"OAK\", \"AFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.raiders+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"San Diego Chargers\", \"SD\", \"AFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.chargers+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Dallas Cowboys\", \"DAL\", \"NFC EAST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.cowboys+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"New York Giants\", \"NYG\", \"NFC EAST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.giants+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Philadelphia Eagles\", \"PHI\", \"NFC EAST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.eagles+"); ");
        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Washington Redskins\", \"WAS\", \"NFC EAST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.redskins+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Chicago Bears\", \"CHI\", \"NFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.bears+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Detroit Lions\", \"DET\", \"NFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.lions+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Green Bay Packers\", \"GB\", \"NFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.packers+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Minnesota Vikings\", \"MIN\", \"NFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.vikings+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Atlanta Falcons\", \"ATL\", \"NFC SOUTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.falcons+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Carolina Panthers\", \"CAR\", \"NFC SOUTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.panthers+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"New Orleans Saints\", \"NO\", \"NFC SOUTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.saints+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Tampa Bay Buccaneers\", \"TB\", \"NFC SOUTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.buccaneers+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Arizona Cardinals\", \"ARI\", \"NFC WEST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.cardinals+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"San Francisco 49ers\", \"SF\", \"NFC WEST\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.forty_niners+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"Seattle Seahawks\", \"SEA\", \"AFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.seahawks+"); ");

        sqLiteDatabase.execSQL("INSERT INTO "+TABLE_TEAMS
                +" ("+COLUMN_LONGNAME+", "+COLUMN_SHORTNAME+", "+COLUMN_CONFERENCE+", "+COLUMN_HOMETOWN+", "+COLUMN_COLOR+", "+COLUMN_IMAGEID
                +") VALUES ("
                +"\"St. Louis Rams\", \"STL\", \"AFC NORTH\",\"Baltimore, MD\", "+ Color.parseColor("#141F94")+", "+ R.drawable.rams+"); ");

        /*Team ravens = new Team("Baltimore Ravens", "BAL", "AFC North", "Baltimore, MD",
                Color.parseColor("#141F94"));
        ravens.setImageId(R.drawable.ravens);
        Team bengals = new Team("Cinc
        innati Bengals", "CIN", "AFC North", "Cincinatti, OH",
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
        game9.setAwayScore(2899);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
    {
        sqLiteDatabase.execSQL("drop table if exists "+ TABLE_TEAMS);
        onCreate(sqLiteDatabase);
    }
}
