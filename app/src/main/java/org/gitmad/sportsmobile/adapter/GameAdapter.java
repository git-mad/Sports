package org.gitmad.sportsmobile.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.Team;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends ArrayAdapter<Game> {

    private Context mContext;
    private List<Game> mGameList;

    public GameAdapter(final Context context, final List<Game> gameList) {
        super(context, R.layout.game_row, gameList);
        mContext = context;
        mGameList = gameList;
    }

    private static class ViewHolder {

        private final List<View> viewList;

        public ViewHolder(final View view, final List<View> viewList) {
            this.viewList = viewList;
        }
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Game game = mGameList.get(position);
        final List<Team> teamList = game.getTeamList();
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        final ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.game_row, parent, false);
            final List<View> viewList = new ArrayList<View>(teamList.size());
            for (Team ignored : teamList) {
                final View view = layoutInflater.inflate(R.layout.game_item,
                        (ViewGroup) convertView, false);
                viewList.add(view);
                ((ViewGroup) convertView).addView(view);
            }
            holder = new ViewHolder(convertView, viewList);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (teamList.size() != holder.viewList.size())
            throw new RuntimeException("Team size differs from number of child views.");
        final int[] colors = new int[teamList.size()];
        for (int i = 0; i < teamList.size(); i++) {
            final Team team = teamList.get(i);
            final View view = holder.viewList.get(i);
            final TextView teamName = (TextView) view.findViewById(R.id.team_name);
            final ImageView teamLogo = (ImageView) view.findViewById(R.id.team_logo);
            teamName.setText(team.getLongName());
            teamLogo.setImageResource(team.getImageId());
            colors[i] = team.getPrimaryColor();
        }
        final StateListDrawable sld = new StateListDrawable();
        final GradientDrawable gradientDrawable = new GradientDrawable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(colors);
            gradientDrawable.setAlpha(100);
            sld.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
            convertView.setBackground(sld);
        }
        return convertView;
    }
}
