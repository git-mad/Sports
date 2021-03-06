package org.gitmad.sportstv.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.gitmad.sportstv.R;
import org.gitmad.sportstv.activity.GameActivity;
import org.gitmad.sportstv.adapter.GameAdapter;
import org.gitmad.sportstv.model.Game;
import org.gitmad.sportstv.model.MockScoreProvider;
import org.gitmad.sportstv.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFragment extends Fragment {

    private static final String KEY_GAME_LIST = "KEY_GAME_LIST";

    private ListView mListView;
    private GameAdapter mGameAdapter;
    private ArrayList<Game> mGameList;
    private List<Team> mTeamList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        final MockScoreProvider mockScoreProvider = new MockScoreProvider();
        if (savedInstanceState == null) {
            mGameList = mockScoreProvider.getGameList();
        } else {
            mGameList = savedInstanceState.getParcelableArrayList(KEY_GAME_LIST);
        }
        mTeamList = mockScoreProvider.getTeamList();
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
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((GameActivity) getActivity())
                        .setScoreText(((GameAdapter.ViewHolder) view.getTag()).scoreText);
            }
        });
        if (savedInstanceState == null && !mGameList.isEmpty()) {
            mListView.performItemClick(mGameAdapter.getView(0, null, null),
                    0, mGameAdapter.getItemId(0));
        }
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
        final Game game = new Game(mTeamList.get(index0), mTeamList.get(index1));
        game.setHomeScore(rand.nextInt(101));
        game.setAwayScore(rand.nextInt(101));
        mGameList.add(0, game);
        mGameAdapter.notifyDataSetChanged();
        mListView.setItemChecked(mListView.getCheckedItemPosition() + 1, true);
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
