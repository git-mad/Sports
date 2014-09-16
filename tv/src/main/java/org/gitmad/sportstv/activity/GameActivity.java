package org.gitmad.sportstv.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import org.gitmad.sportstv.R;
import org.gitmad.sportstv.fragment.GameFragment;

public class GameActivity extends Activity {

    private static final String KEY_SCORE_TEXT = "KEY_SCORE_TEXT";

    private TextView mScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mScoreView = (TextView) findViewById(R.id.score_view);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new GameFragment())
                    .commit();
        } else {
            mScoreView.setText(savedInstanceState.getCharSequence(KEY_SCORE_TEXT));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putCharSequence(KEY_SCORE_TEXT, mScoreView.getText());
        super.onSaveInstanceState(outState);
    }

    public void setScoreText(CharSequence score) {
        mScoreView.setText(score);
    }
}
