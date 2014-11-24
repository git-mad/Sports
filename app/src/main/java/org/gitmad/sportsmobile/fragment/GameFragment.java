package org.gitmad.sportsmobile.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.TitleGettable;
import org.gitmad.sportsmobile.adapter.GameAdapter;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.ScoreProvider;

import java.util.ArrayList;
import java.util.Hashtable;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GameFragment extends Fragment implements TitleGettable {

    private ListView mListView;
    private GameAdapter mGameAdapter;
    private ArrayList<Game> mGameList;
    private ScoreProvider mScoreProvider;

    @Override
    public int getTitleResource() {
        return R.string.game_list_title;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScoreProvider = new ScoreProvider(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return mListView = (ListView) inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGameList = new ArrayList<Game>();
        mGameAdapter = new GameAdapter(getActivity(), mGameList);
        mListView.setAdapter(mGameAdapter);
        mScoreProvider.listGames(new Callback<Hashtable<String, Game>>() {
            @Override
            public void success(Hashtable<String, Game> stringGameDictionary, Response response) {
                mGameList.addAll(stringGameDictionary.values());
                mGameAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Network", error.getMessage());
            }
        });
    }
}
