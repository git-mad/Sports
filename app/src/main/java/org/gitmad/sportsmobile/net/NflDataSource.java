package org.gitmad.sportsmobile.net;

import org.gitmad.sportsmobile.model.Game;

import java.util.Hashtable;

import retrofit.Callback;
import retrofit.http.GET;

public interface NflDataSource {
    @GET("/liveupdate/scores/scores.json")
    public void listGames(Callback<Hashtable<String, Game>> cb);
}
