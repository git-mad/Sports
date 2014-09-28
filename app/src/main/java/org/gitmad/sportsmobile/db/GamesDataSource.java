package org.gitmad.sportsmobile.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.Team;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 9/21/2014.
 */
public class GamesDataSource
{
    private SQLiteDatabase database;
    private Context context;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
            MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_HOME_SCORE,
            MySQLiteHelper.COLUMN_AWAY_SCORE,
            MySQLiteHelper.COLUMN_QUARTER,
            MySQLiteHelper.COLUMN_MINUTES,
            MySQLiteHelper.COLUMN_SECONDS,
            MySQLiteHelper.COLUMN_HOME_ID,
            MySQLiteHelper.COLUMN_AWAY_ID
    };

    public GamesDataSource(Context context)
    {
        this.context=context;
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }
    public void close()
    {
        dbHelper.close();
    }

    public Game addGame(Team homeTeam, Team awayTeam, int homeScore, int awayScore, int quarter, int minutes, int seconds) throws SQLException
    {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_HOME_ID, homeTeam.getId());
        values.put(MySQLiteHelper.COLUMN_AWAY_ID, awayTeam.getId());
        values.put(MySQLiteHelper.COLUMN_HOME_SCORE, homeScore);
        values.put(MySQLiteHelper.COLUMN_AWAY_SCORE, awayScore);
        values.put(MySQLiteHelper.COLUMN_QUARTER, quarter);
        values.put(MySQLiteHelper.COLUMN_MINUTES, minutes);
        values.put(MySQLiteHelper.COLUMN_SECONDS, seconds);

        long insertId = database.insert(MySQLiteHelper.TABLE_GAMES, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_GAMES, allColumns, MySQLiteHelper.COLUMN_ID+ " = "+ insertId, null, null, null, null);
        cursor.moveToFirst();
        Game game = cursorToGame(cursor);
        cursor.close();
        return game;
    }


    public List<Game> getAllGames() throws SQLException
    {
        List<Game> games = new ArrayList<Game>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_GAMES, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Game game = cursorToGame(cursor);
            games.add(game);
            cursor.moveToNext();
        }
        cursor.close();
        return games;
    }

    public Game cursorToGame(Cursor cursor) throws SQLException
    {
        TeamsDataSource teamDS = new TeamsDataSource(context);
        teamDS.open();
        Team homeTeam = teamDS.getTeam(cursor.getLong(6));
        Team awayTeam = teamDS.getTeam(cursor.getLong(7));
        teamDS.close();
        Game game = new Game(cursor.getLong(0), homeTeam, awayTeam);
        game.setHomeScore(cursor.getInt(1));
        game.setAwayScore(cursor.getInt(2));
        game.setQuarter(cursor.getInt(3));
        game.setMinutesLeft(cursor.getInt(4));
        game.setSecondsLeft(cursor.getInt(5));
        return game;
    }
}
