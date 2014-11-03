package org.gitmad.sportsmobile.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.gitmad.sportsmobile.net.NflDataSource;

import java.util.Hashtable;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ScoreProvider
{
    private static final String ENDPOINT = "http://www.nfl.com";

    private NflDataSource dataSource;

    public ScoreProvider(Context context)
    {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Game.class, new GameDeserializer(context));
        Gson gson = builder.create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .build();
        dataSource = restAdapter.create(NflDataSource.class);
    }

    public void listGames(Callback<Hashtable<String, Game>> callback)
    {
        dataSource.listGames(callback);
    }

}
