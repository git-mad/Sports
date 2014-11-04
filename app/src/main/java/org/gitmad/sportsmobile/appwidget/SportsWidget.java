package org.gitmad.sportsmobile.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.RemoteViews;

import org.gitmad.sportsmobile.R;
import org.gitmad.sportsmobile.model.Game;
import org.gitmad.sportsmobile.model.ScoreProvider;
import org.gitmad.sportsmobile.model.Team;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SportsWidget  extends AppWidgetProvider {

    private static final String ACTION_CLICK_TO_NEXT = "ACTION_CLICK_TO_NEXT";

    private int mGameNum = 0;

    @Override
    public void onUpdate(final Context context,
                         final AppWidgetManager appWidgetManager,
                         final int[] appWidgetIds) {

        final ScoreProvider scoreProvider = new ScoreProvider(context);
        scoreProvider.listGames(new Callback<Hashtable<String, Game>>() {
            @Override
            public void success(Hashtable<String, Game> stringGameDictionary, Response response) {
                updateGames(new ArrayList<Game>(stringGameDictionary.values()),
                        context,
                        appWidgetManager,
                        appWidgetIds);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Network", error.getMessage());
            }
        });
    }

    private void updateGames(final List<Game> gameList,
                             final Context context,
                             final AppWidgetManager appWidgetManager,
                             final int[] appWidgetIds) {

        final Game game = gameList.get(mGameNum % gameList.size());

        for (int appWidgetId : appWidgetIds) {
            final RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.game_row);

            Map<Team, Integer> teamScoreMap = game.getTeamScoreMap();

            for (Team team : teamScoreMap.keySet()) {
                final RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                        R.layout.game_item);
                views.addView(R.id.game_row_layout, remoteViews);
                remoteViews.setTextViewText(R.id.team_name, team.getLongName());
                remoteViews.setImageViewResource(R.id.team_logo, team.getImageId());
                remoteViews.setTextViewText(R.id.score, String.valueOf(teamScoreMap.get(team)));
            }

            final Intent intent = new Intent(context, SportsWidget.class);
            intent.setAction(ACTION_CLICK_TO_NEXT);
            final PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            views.setOnClickPendingIntent(R.id.game_row_layout, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (ACTION_CLICK_TO_NEXT.equals(intent.getAction())) {
            mGameNum++;
            final Intent updateIntent = new Intent(context, SportsWidget.class);
            updateIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            context.sendBroadcast(updateIntent);
        } else {
            super.onReceive(context, intent);
        }
    }
}
