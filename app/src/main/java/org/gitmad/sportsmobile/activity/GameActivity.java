package org.gitmad.sportsmobile.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.TitleGettable;
import org.gitmad.sportsmobile.fragment.GameFragment;
import org.gitmad.sportsmobile.fragment.LoginFragment;
import org.gitmad.sportsmobile.wearreceiver.SensorReceiverFragment;

public class GameActivity extends ActionBarActivity {

    private static final String FIRST_RUN = "FIRST_RUN";
    private static final String KEY_NAV_CHECK_BOX = "KEY_NAV_CHECK_BOX";

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private View mDrawerNav;
    private ListView mDrawerList;
    private CheckBox mNavCheckBox;

    private ActionBarDrawerToggle mDrawerToggle;

    private String[] mSectionNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSectionNames = getResources().getStringArray(R.array.section_names);

        setContentView(R.layout.activity_game);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerNav = findViewById(R.id.navigation_drawer);
        mDrawerList = (ListView) mDrawerNav.findViewById(R.id.navigation_drawer_list);
        mNavCheckBox = (CheckBox) mDrawerNav.findViewById(R.id.nav_check_box);

        setSupportActionBar(mToolbar);

        setupNavigationDrawer();

        if (savedInstanceState == null) {
            mDrawerList.setItemChecked(0, true);
            selectItem(0);
        } else {
            mNavCheckBox.setChecked(savedInstanceState.getBoolean(KEY_NAV_CHECK_BOX));
            doFragmentTitleChange();
        }

        final SharedPreferences prefs
                = PreferenceManager.getDefaultSharedPreferences(this);
        final boolean firstRun
                = prefs.getBoolean(FIRST_RUN, true);
        if (firstRun) {
            prefs.edit().putBoolean(FIRST_RUN, false).apply();
            mDrawerLayout.openDrawer(mDrawerNav);
        }

        getFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        doFragmentTitleChange();
                    }
                });
    }

    private void doFragmentTitleChange() {
        final Fragment fragment = getFragmentManager().findFragmentById(R.id.container);
        if ((fragment instanceof TitleGettable)) {
            setTitle(((TitleGettable) fragment).getTitleResource());
        }
    }
    private void selectItem(final int position) {
        //setTitle(mSectionNames[position]);
        mDrawerLayout.closeDrawer(mDrawerNav);
        // pop entire back stack
        getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        final Fragment currFrag = getFragmentManager().findFragmentById(R.id.container);
        final FragmentTransaction transaction = getFragmentManager().beginTransaction()
                .addToBackStack(null);
        if (currFrag != null) {
            transaction.remove(currFrag);
        }
        final Fragment fragment;
        switch (position) {
            case 0:
                fragment = new GameFragment();
                break;
            case 1:
                fragment = new LoginFragment();
                break;
            case 2:
                fragment = new SensorReceiverFragment();
                break;
            default:
                throw new RuntimeException("Clicked unimplemented section");
        }
        transaction
                .add(R.id.container, fragment)
                .commit();
    }

    private void setupNavigationDrawer() {
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.nav_drawer_item, mSectionNames));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView parent, final View view,
                                    final int position, final long id) {
                selectItem(position);
            }
        });
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                doDrawerClosed();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                doDrawerOpened();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // disable hamburger-arrow animation
                super.onDrawerSlide(drawerView, 0);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(
                R.color.sports_orange_dark));
    }

    private void doDrawerClosed() {
        invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
    }

    private void doDrawerOpened() {
        invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();

        if (mDrawerLayout.isDrawerOpen(mDrawerNav)) {
            doDrawerOpened();
        } else {
            doDrawerClosed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
     public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(KEY_NAV_CHECK_BOX, mNavCheckBox.isChecked());
        super.onSaveInstanceState(outState);
    }
}
