package org.gitmad.sportsmobile.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.gitmad.sportsmobile.SportsApplication;
import org.gitmad.sportsmobile.db.TeamsDataSource;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.sql.SQLException;

/**
 * Created by Alex on 10/19/2014.
 */
public class GameDeserializer implements JsonDeserializer<Game>
{

    @Override
    public Game deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        String clock = "";
        int homeScore = 0;
        int awayScore = 0;

        final JsonObject root = json.getAsJsonObject();


        JsonElement clockElement = root.get("clock");
        JsonElement homeScoreElement = root.getAsJsonObject("home").getAsJsonObject("score").get("T");
        JsonElement awayScoreElement = root.getAsJsonObject("away").getAsJsonObject("score").get("T");

        if(!clockElement.isJsonNull())
        {
            clock = clockElement.getAsString();
        }
        if(!homeScoreElement.isJsonNull())
        {
            homeScore = homeScoreElement.getAsInt();
        }
        if(!awayScoreElement.isJsonNull())
        {
            awayScore = awayScoreElement.getAsInt();
        }

        Team homeTeam = null;
        Team awayTeam = null;
        TeamsDataSource teamDs = new TeamsDataSource(SportsApplication.getAppContext());
        try {
            teamDs.open();
             homeTeam = teamDs.lookup(root.getAsJsonObject("home").get("abbr").getAsString());
            awayTeam = teamDs.lookup(root.getAsJsonObject("away").get("abbr").getAsString());
            teamDs.close();
        }
        catch(SQLException sqex){}
        catch(Exception ex){ex.printStackTrace();}

        Game game = new Game(homeTeam, awayTeam, homeScore, awayScore, clock);

        return game;

    }
}
