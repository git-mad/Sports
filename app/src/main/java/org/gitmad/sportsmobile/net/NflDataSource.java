package org.gitmad.sportsmobile.net;

import org.gitmad.sportsmobile.model.Game;

import java.util.Dictionary;
import java.util.Hashtable;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Alex on 10/19/2014.
 */
public interface NflDataSource {
    @GET("/liveupdate/scores/scores.json")
    public void listGames(Callback<Hashtable<String, Game>> cb);
}
