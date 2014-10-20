package org.gitmad.sportsmobile.adapter;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.Team;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends ArrayAdapter<Game> {

    private final Context mContext;
    private final List<Game> mGameList;
    private final List<Game> mViewedGames;

    public GameAdapter(final Context context, final List<Game> gameList) {
        super(context, R.layout.game_row, gameList);
        mContext = context;
        mGameList = gameList;
        mViewedGames = new ArrayList<Game>(mGameList.size());
    }

    private static class ViewHolder {

        private ViewHolder(final View view) {}
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Game game = mGameList.get(position);
        final Team homeTeam = game.getHomeTeam();
        final Team awayTeam = game.getAwayTeam();
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        final ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.game_row, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ((ViewGroup) convertView).removeAllViews();
        final List<View> viewList = new ArrayList<View>(2);
        for (int i=0; i<2; i++) {
            final View view = layoutInflater.inflate(R.layout.game_item,
                    (ViewGroup) convertView, false);
            viewList.add(view);
            ((ViewGroup) convertView).addView(view);
        }



        final StringBuilder teamNamesBuilder = new StringBuilder();
        final int[] colors = new int[2];

        View view = viewList.get(0);
        TextView teamName = (TextView) view.findViewById(R.id.team_name);
        ImageView teamLogo = (ImageView) view.findViewById(R.id.team_logo);
        TextView teamScore = (TextView) view.findViewById(R.id.score);
        teamName.setText(homeTeam.getLongName());
        teamLogo.setImageResource(homeTeam.getImageId());
        teamScore.setText(Integer.toString(game.getHomeScore()));
        teamNamesBuilder.append(homeTeam.getLongName());
        teamNamesBuilder.append(" ");
        colors[0] = homeTeam.getPrimaryColor();

        view = viewList.get(1);
        teamName = (TextView) view.findViewById(R.id.team_name);
        teamLogo = (ImageView) view.findViewById(R.id.team_logo);
        teamScore = (TextView) view.findViewById(R.id.score);
        teamName.setText(awayTeam.getLongName());
        teamScore.setText(Integer.toString(game.getAwayScore()));
        teamLogo.setImageResource(awayTeam.getImageId());
        teamNamesBuilder.append(awayTeam.getLongName());
        teamNamesBuilder.append(" ");
        colors[1] = awayTeam.getPrimaryColor();

        final StateListDrawable sld = new StateListDrawable();
        final GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(colors);
            gradientDrawable.setAlpha(100);
            sld.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
            convertView.setBackground(sld);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, teamNamesBuilder.toString());
                mContext.startActivity(intent);
            }
        });
        // assumes that we never have two of the same game in this adapter
        if (!mViewedGames.contains(game)) {
            mViewedGames.add(game);
            convertView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.pop_in));
        }
        return convertView;
    }
}
