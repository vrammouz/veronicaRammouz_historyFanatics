package com.example.veronica.historyfanatics;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TodayActivity extends AppCompatActivity
{
    public String today,title="";
    public TextView data,yearText,titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");

        titleText = (TextView)findViewById(R.id.event_title);
        yearText = (TextView)findViewById(R.id.event_year);
        data = (TextView) findViewById(R.id.event_data);

        if(title.equals(""))
            getToday();

        else
            viewStory();
    }

    public void viewStory()
    {
        StoriesInHistory storiesInHistory = new StoriesInHistory();
        int length = storiesInHistory.eventsArray.length;
        for(int i=0;i<length;i++)
        {
            if(title.equals(storiesInHistory.eventsArray[i].getTitle()))
            {
                Story story = storiesInHistory.eventsArray[i];
                yearText.setText(story.getYear());
                titleText.setText(title);
                data.setText(story.getStory());
            }
        }
    }

    public void getToday()
    {
        String result = "";
        DownloadTask task = new DownloadTask();

        try
        {
            result = task.execute("view-source:https://www.history.com/this-day-in-history").get();
            Pattern p = Pattern.compile("<div class=\"m-detail--body\"><p>(.*?)</p></div>");
            Matcher m = p.matcher(result);

            while(m.find())
            {
                today+=m.group(1);
            }data.setText(today);
            Log.i("Logging", "On this day, " + today);
        }
        catch (Exception e)
        {
            Log.i("Logging","Error executing download task");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.home:
                Log.i("Logging", "Main Menu");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.save:
                String title = titleText.getText().toString();
                Intent intentsave = new Intent(getApplicationContext(),SettingsActivity.class);
                intentsave.putExtra("savedStory",title);
                startActivity(intentsave);
                Toast.makeText(TodayActivity.this, "Story successfully saved!", Toast.LENGTH_SHORT).show();
                Log.i("Logging", "Saved story");
                break;
            default:
                Log.i("Logging", "Error Today");
                break;
        }
        return true;
    }

    public class DownloadTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... urls)
        {
            String website = "";

            try{
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while(data != -1){
                    website += (char)data;
                    data = reader.read();
                }
            }catch (Exception e)
            {
                website = "Unable to retrieve web data";
                Log.i("Logging",website);
            }
            return website;
        }
    }

}
