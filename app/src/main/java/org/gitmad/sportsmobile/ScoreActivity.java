package org.gitmad.sportsmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andre on 9/7/14.
 */
public class ScoreActivity extends Activity {

    private MockScoreProvider scoreProvider;
    private ArrayList<Score> currentScores;

    private TextView homeTextView;
    private TextView awayTextView;
    private TextView homeScoreTextView;
    private TextView awayScoreTextView;
    private ImageView homeImageView;
    private ImageView awayImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        scoreProvider = new MockScoreProvider();
        currentScores = scoreProvider.getCurrentScores();

        Team homeTeam = currentScores.get(0).getHomeTeam();
        Team awayTeam = currentScores.get(0).getAwayTeam();

        //Here is how you would find an Android component in the XML file and initialize it.
        homeImageView = (ImageView) findViewById(R.id.homeImageView1);
        awayImageView = (ImageView) findViewById(R.id.awayImageView1);

        //Set the text views to values from our Mock Data
        homeTextView = (TextView) findViewById(R.id.homeTextView1);
        awayTextView = (TextView) findViewById(R.id.awayTextView1);
        homeScoreTextView = (TextView) findViewById(R.id.homeScore1);
        awayScoreTextView = (TextView) findViewById(R.id.awayScore1);

        homeTextView.setText(homeTeam.getLong_name());
        awayTextView.setText(awayTeam.getLong_name());

        homeScoreTextView.setText("" + currentScores.get(0).getHomeScore());
        awayScoreTextView.setText("" + currentScores.get(0).getAwayScore());

        //Setting images to values from our Mock Data.
        //Note that the stuff in R.java maps to integers.
        //getImageId() returns the Integer image id for the team's logo
        //R.drawable.falcons is what we would use to get the logo of the falcons.
        homeImageView.setImageResource(homeTeam.getImageId());
        awayImageView.setImageResource(awayTeam.getImageId());

        //etc... for the other teams that you would want to show on the view.
        //Exercise: Try to add some more teams yourself!
        //Stay tuned for more like how to display this content in a ListView!
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
