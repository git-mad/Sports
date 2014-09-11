package org.gitmad.sportstv.activity;

import android.app.Activity;
import android.os.Bundle;

import org.gitmad.sportstv.R;
import org.gitmad.sportstv.fragment.GameFragment;

public class GameActivity extends Activity {

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
