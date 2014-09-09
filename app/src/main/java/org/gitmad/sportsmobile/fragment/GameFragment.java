package org.gitmad.sportsmobile.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.adapter.GameAdapter;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.MockScoreProvider;

import java.util.List;

public class GameFragment extends Fragment {

    private ListView mListView;
    private GameAdapter mGameAdapter;
    private List<Game> mGameList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return mListView = (ListView) inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final MockScoreProvider mockScoreProvider = new MockScoreProvider();
        mGameList = mockScoreProvider.getGameList();
        mGameAdapter = new GameAdapter(getActivity(), mGameList);
        mListView.setAdapter(mGameAdapter);
    }

}
