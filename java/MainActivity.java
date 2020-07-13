package com.example.veronica.historyfanatics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    ListView buttonListView;
    ArrayList<String> buttonList;

    ArrayAdapter<String> adapter;
    String today,events,shows,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = getResources().getString(R.string.button1_main);
        events = getResources().getString(R.string.button2_main);
        shows = getResources().getString(R.string.button3_main);
        settings = getResources().getString(R.string.button4_main);

        buttonListView = (ListView)findViewById(R.id.main_listView);
        buttonList = new ArrayList<>();

        buttonList.add(today);
        buttonList.add(events);
        buttonList.add(shows);
        buttonList.add(settings);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, buttonList);
        buttonListView.setAdapter(adapter);
        buttonListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                        Log.i("Logging","Today");
                        Intent intentToday = new Intent(getApplicationContext(), TodayActivity.class);
                        startActivity(intentToday);
                        break;
                    case 1:
                        Log.i("Logging","Stories");
                        Intent intentStories = new Intent(getApplicationContext(),StoriesActivity.class);
                        startActivity(intentStories);
                        break;
                    case 2:
                        Log.i("Logging","Shows");
                        Intent intentShows = new Intent(getApplicationContext(),ShowsActivity.class);
                        startActivity(intentShows);
                        break;
                    case 3:
                        Log.i("Logging","Settings");
                        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Log.i("Logging", "Error Main");
                        break;
                }
            }
        });
    }
}

