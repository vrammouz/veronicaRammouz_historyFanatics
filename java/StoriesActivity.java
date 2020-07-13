package com.example.veronica.historyfanatics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StoriesActivity extends AppCompatActivity
{
    ArrayList<String> eventList;
    ListView lv ;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        lv = (ListView)findViewById(R.id.story_list);

        addStories();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                sendTitle(position);
            }
        });
    }

    public void sendTitle(int position)
    {
        Intent intent = new Intent(getApplicationContext(), TodayActivity.class);
        intent.putExtra("title", eventList.get(position));
        Log.i("Logging","title put");
        startActivity(intent);
    }

    public void addStories()
    {
        StoriesInHistory storiesInHistory = new StoriesInHistory();
        int length = storiesInHistory.eventsArray.length;
        eventList = new ArrayList<>();
        for (int i=0;i<length;i++)
        {
            Story story = storiesInHistory.eventsArray[i];
            String title = storiesInHistory.getStoryTitle(story);
            eventList.add(title);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,eventList);
        lv = (ListView)findViewById(R.id.story_list);
        lv.setAdapter(adapter);

        Log.i("Logging","Stories added");
    }

    public void randomStory(View view)
    {
        StoriesInHistory stories = new StoriesInHistory();
        Story story = stories.getRandomStory();
        String title = story.getTitle();

        eventList.clear();
        eventList.add(title);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,eventList);
        lv = (ListView)findViewById(R.id.story_list);
        lv.setAdapter(adapter);

        Log.i("Logging","Random story title: " + title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        inflater.inflate(R.menu.refresh_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.home:
                Log.i("Logging", "Main Menu");
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.refresh:
                Log.i("Logging", "Stories Activity refresh");
                Intent intentR = new Intent(getApplicationContext(),StoriesActivity.class);
                startActivity(intentR);
                break;
            default:
                Log.i("Logging","Error Today");
                break;
        }
        return true;
    }
}
