package org.gitmad.sportsmobile.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.fragment.GameFragment;

public class GameActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new GameFragment())
                    .commit();
        }
    }
}
