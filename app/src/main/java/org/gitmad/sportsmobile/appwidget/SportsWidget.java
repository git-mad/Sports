package org.gitmad.sportsmobile.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
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

    private static final String ACTION_APPWIDGET_ADVANCE = "ACTION_APPWIDGET_ADVANCE";
    private static final String EXTRA_GAME_NUM = "EXTRA_GAME_NUM";

    @Override
    public void onUpdate(final Context context,
                         final AppWidgetManager appWidgetManager,
                         final int[] appWidgetIds) {
        networkCallGames(context, appWidgetManager, appWidgetIds, 0);
    }

    private void networkCallGames(final Context context,
                                  final AppWidgetManager appWidgetManager,
                                  final int[] appWidgetIds,
                                  final int gameNum) {
        final ScoreProvider scoreProvider = new ScoreProvider(context);
        scoreProvider.listGames(new Callback<Hashtable<String, Game>>() {
            @Override
            public void success(Hashtable<String, Game> stringGameDictionary, Response response) {
                updateGames(new ArrayList<Game>(stringGameDictionary.values()),
                        gameNum,
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
                             final int gameNum,
                             final Context context,
                             final AppWidgetManager appWidgetManager,
                             final int[] appWidgetIds) {

        if (gameList.size() <= 0) return;
        final Game game = gameList.get(gameNum % gameList.size());

        for (int appWidgetId : appWidgetIds) {
            final RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.game_row);
            views.removeAllViews(R.id.game_row_layout);

            final Map<Team, Integer> teamScoreMap = game.getTeamScoreMap();

            for (Team team : teamScoreMap.keySet()) {
                final RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                        R.layout.game_item);
                views.addView(R.id.game_row_layout, remoteViews);
                remoteViews.setTextViewText(R.id.team_name, team.getLongName());
                remoteViews.setImageViewResource(R.id.team_logo, team.getImageId());
                remoteViews.setTextViewText(R.id.score, String.valueOf(teamScoreMap.get(team)));
            }

            final Intent advanceIntent = new Intent(context, SportsWidget.class);
            advanceIntent.setAction(ACTION_APPWIDGET_ADVANCE);
            advanceIntent.putExtra(EXTRA_GAME_NUM, gameNum + 1);
            // use unique request code to prevent reuse of Intent
            final PendingIntent pendingIntent
                    = PendingIntent.getBroadcast(context, gameNum, advanceIntent, 0);
            views.setOnClickPendingIntent(R.id.game_row_layout, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (ACTION_APPWIDGET_ADVANCE.equals(intent.getAction())) {
            final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            final ComponentName sportsWidget = new ComponentName(context.getPackageName(),
                    SportsWidget.class.getName());
            final int[] appWidgetIds = appWidgetManager.getAppWidgetIds(sportsWidget);
            networkCallGames(context, appWidgetManager, appWidgetIds,
                    intent.getIntExtra(EXTRA_GAME_NUM, 0));
        } else {
            super.onReceive(context, intent);
        }
    }
}
