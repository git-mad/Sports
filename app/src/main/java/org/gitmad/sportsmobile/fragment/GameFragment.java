package org.gitmad.sportsmobile.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.activity.LoginActivity;
import org.gitmad.sportsmobile.adapter.GameAdapter;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.ScoreProvider;

import java.util.ArrayList;
import java.util.Hashtable;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GameFragment extends Fragment {

    private ListView mListView;
    private GameAdapter mGameAdapter;
    private ArrayList<Game> mGameList;
    private ScoreProvider mScoreProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.game, menu);
    }
}
