package org.gitmad.sportsmobile.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.gitmad.sportsmobile.net.NflDataSource;

import java.util.Dictionary;
import java.util.Hashtable;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Alex on 10/19/2014.
 */
public class ScoreProvider
{
    NflDataSource dataSource;

    public ScoreProvider()
    {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Game.class, new GameDeserializer());
        Gson gson = builder.create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.nfl.com")
                .setConverter(new GsonConverter(gson))
                .build();
        dataSource = restAdapter.create(NflDataSource.class);
    }

    public void listGames(Callback<Hashtable<String, Game>> callback)
    {
        dataSource.listGames(callback);
    }

}
