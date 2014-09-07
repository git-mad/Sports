package org.gitmad.sportsmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TableRow;

/**
 * Created by andre on 9/7/14.
 */
public class ScoreActivity extends Activity {

    ImageView homeImageView1;
    ImageView homeImageView2;
    ImageView homeImageView3;

    ImageView awayImageView1;
    ImageView awayImageView2;
    ImageView awayImageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);

        homeImageView1 = (ImageView) findViewById(R.id.homeImageView1);
        homeImageView2 = (ImageView) findViewById(R.id.homeImageView2);
        homeImageView3 = (ImageView) findViewById(R.id.homeImageView3);

        awayImageView1 = (ImageView) findViewById(R.id.awayImageView1);
        awayImageView2 = (ImageView) findViewById(R.id.awayImageView2);
        awayImageView3 = (ImageView) findViewById(R.id.awayImageView3);
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
