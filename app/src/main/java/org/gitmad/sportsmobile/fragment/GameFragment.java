package org.gitmad.sportsmobile.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.adapter.GameAdapter;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.MockScoreProvider;
import org.gitmad.sportsmobile.model.Team;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFragment extends Fragment {

    private static final String KEY_GAME_LIST = "KEY_GAME_LIST";

    private ListView mListView;
    private GameAdapter mGameAdapter;
    private ArrayList<Game> mGameList;
    private ArrayList<Team> mTeamList;
    private MockScoreProvider mockScoreProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mockScoreProvider = new MockScoreProvider(this.getActivity());
        if (savedInstanceState == null) {
            mGameList = (ArrayList<Game>)mockScoreProvider.getGameList();
        } else {
            mGameList = savedInstanceState.getParcelableArrayList(KEY_GAME_LIST);
        }
        mTeamList = (ArrayList<Team>)mockScoreProvider.getTeamList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return mListView = (ListView) inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mGameAdapter = new GameAdapter(getActivity(), mGameList);
        mListView.setAdapter(mGameAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(KEY_GAME_LIST, mGameList);
        super.onSaveInstanceState(outState);
    }

    private void addRandomGame() {
        if (mTeamList.size() < 2) return;
        final Random rand = new Random();
        int index0 = 0; int index1 = 0;
        while (index0 == index1) {
            index0 = rand.nextInt(mTeamList.size());
            index1 = rand.nextInt(mTeamList.size());
        }
            final Game game =  mockScoreProvider.addGame(mTeamList.get(index0), mTeamList.get(index1), rand.nextInt(101), rand.nextInt(101), rand.nextInt(4), rand.nextInt(60),rand.nextInt(60));
            if(game!=null) {
                mGameList.add(0, game);
                mGameAdapter.notifyDataSetChanged();
            }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game:
                addRandomGame();
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
