package org.gitmad.sportsmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import org.gitmad.sportsmobile.R;

public class SplashActivity extends Activity {

    private static final String KEY_FIRST_TIME = "KEY_FIRST_TIME";

    private Button mLeaveButton;
    private CirclePageIndicator mViewPagerIndicator;
    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean(KEY_FIRST_TIME, true)) {
            leave();
            return;
        }
        setContentView(R.layout.activity_splash);
        final Resources resources = getResources();
        mLeaveButton = (Button) findViewById(R.id.leave_splash_button);
        mViewPagerIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mViewPager = (ViewPager) findViewById(R.id.splash_pager);
        mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                final ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
                layoutParams.width = ViewPager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = ViewPager.LayoutParams.WRAP_CONTENT;
                layoutParams.gravity = Gravity.CENTER;
                final int textRes = position == 0
                        ? R.string.splash_text_0 : R.string.splash_text_1;
                final TextView textView = new TextView(SplashActivity.this);
                textView.setText(textRes);
                textView.setTextSize(resources.getDimension(R.dimen.splash_text_size));
                textView.setPadding(
                        (int) resources.getDimension(R.dimen.splash_text_padding_left),
                        0,
                        (int) resources.getDimension(R.dimen.splash_text_padding_right),
                        0);
                textView.setGravity(Gravity.CENTER);
                container.addView(textView, 0);
                return textView;
            }

            @Override public void destroyItem(ViewGroup container, int position,
                                              Object view) {
                container.removeView((View) view);
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPagerIndicator.setViewPager(mViewPager);
        mViewPagerIndicator.setRadius(resources.getDimension(R.dimen.splash_indicator_radius));
        mViewPagerIndicator.setFillColor(resources.getColor(R.color.sports_orange));
        mViewPagerIndicator.setStrokeColor(resources.getColor(R.color.sports_green));
        mViewPagerIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {}

            @Override
            public void onPageSelected(int i) {
                final int textRes = i == 0
                        ? R.string.splash_button_skip : R.string.splash_button_go;
                mLeaveButton.setText(textRes);
            }

            @Override
            public void onPageScrollStateChanged(int i) {}
        });
        mLeaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceManager.getDefaultSharedPreferences(SplashActivity.this).edit()
                        .putBoolean(KEY_FIRST_TIME, false).apply();
                leave();
            }
        });
    }

    private void leave() {
        startActivity(new Intent(this, GameActivity.class));
        finish();
    }
}
