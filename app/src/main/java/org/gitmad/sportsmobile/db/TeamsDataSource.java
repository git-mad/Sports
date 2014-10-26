package org.gitmad.sportsmobile.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.gitmad.sportsmobile.model.Team;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 9/21/2014.
 */
public class TeamsDataSource
{
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = {
            MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_LONGNAME,
            MySQLiteHelper.COLUMN_SHORTNAME,
            MySQLiteHelper.COLUMN_CONFERENCE,
            MySQLiteHelper.COLUMN_HOMETOWN,
            MySQLiteHelper.COLUMN_COLOR,
            MySQLiteHelper.COLUMN_IMAGEID
    };

    public TeamsDataSource(Context context)
    {
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

    public Team createTeam(String longName, String shortName, String conference, String hometown, int color, int image_id)
    {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_LONGNAME, longName);
        values.put(MySQLiteHelper.COLUMN_SHORTNAME, shortName);
        values.put(MySQLiteHelper.COLUMN_CONFERENCE, conference);
        values.put(MySQLiteHelper.COLUMN_HOMETOWN, hometown);
        values.put(MySQLiteHelper.COLUMN_COLOR, color);
        values.put(MySQLiteHelper.COLUMN_IMAGEID, image_id);

        long insertId = database.insert(MySQLiteHelper.TABLE_TEAMS, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TEAMS, allColumns, MySQLiteHelper.COLUMN_ID+ " = "+ insertId, null, null, null, null);
        cursor.moveToFirst();
        Team team = cursorToTeam(cursor);
        cursor.close();
        return team;
    }

    public void deleteTeam(Team team)
    {
        long id = team.getId();
        Log.d("Team deleted with id: "+id, "DB");
        database.delete(MySQLiteHelper.TABLE_TEAMS, MySQLiteHelper.COLUMN_ID + " = "+ id, null);
    }

    public List<Team> getAllTeams()
    {
        List<Team> teams = new ArrayList<Team>();
        Cursor cursor = database.rawQuery("select * from "+MySQLiteHelper.TABLE_TEAMS, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Team team = cursorToTeam(cursor);
            teams.add(team);
            cursor.moveToNext();
        }
        cursor.close();
        return teams;
    }
    public List<Team> getConference(String conference)
    {
        List<Team> teams = new ArrayList<Team>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TEAMS, allColumns, MySQLiteHelper.COLUMN_CONFERENCE +" = "+conference, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Team team = cursorToTeam(cursor);
            teams.add(team);
            cursor.moveToNext();
        }
        cursor.close();
        return teams;

    }

    public Team getTeam(long id)
    {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TEAMS, allColumns, MySQLiteHelper.COLUMN_ID +" = "+id, null, null, null, null);
        cursor.moveToFirst();
        Team team = cursorToTeam(cursor);
        cursor.close();
        return team;
    }

    public Team cursorToTeam(Cursor cursor)
    {
        Team team = new Team(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5));
        team.setImageId(cursor.getInt(6));
        return team;
    }

    public Team lookup(String code)
    {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TEAMS, allColumns, MySQLiteHelper.COLUMN_SHORTNAME+ " = \'"+code+"\'",null,null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount()==0)
            return null;

        Team team = cursorToTeam(cursor);
        cursor.close();
        return team;
    }
}
