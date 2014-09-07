package org.gitmad.sportsmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableRow;
import java.util.ArrayList;

/**
 * Created by andre on 9/7/14.
 */
public class ScoreActivity extends Activity {

    ImageView homeImageView1;
    MockScoreProvider scoreProvider;
    ArrayList<Score> currentScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        scoreProvider = new MockScoreProvider();
        currentScores = scoreProvider.getCurrentScores();


        //Example on how to initialize a component from an Android layout
        //Note that homeImageView1 is the id that we gave the component in score_layout.xml
        homeImageView1 = (ImageView) findViewById(R.id.homeImageView1);

        //Let's try setting the TextViews for some scores here.
        //Code goes here...
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
