package com.example.veronica.historyfanatics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedStoriesFragment extends Fragment
{
    public SharedPreferences storyPreferences,counter;

    ListView storyListView;
    Map<String,String> events;
    ArrayList<String> storyList;
    ArrayAdapter<String> adapter;
    SQLiteDatabase myDatabase;

    public SavedStoriesFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_saved_stories, container, false);

        Intent intent = getActivity().getIntent();
        String title = intent.getStringExtra("savedStory");

        storyListView = (ListView)rootView.findViewById(R.id.saved_list);
        storyList = new ArrayList<>();
        storyList.add(title);

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, storyList);
        storyListView.setAdapter(adapter);

        storyListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                storyList.remove(position);
            }
        });
        return inflater.inflate(R.layout.fragment_saved_stories, container, false);
    }

    public void createDB()
    {
        try
        {
            myDatabase = getContext().openOrCreateDatabase("stories", getContext().MODE_PRIVATE, null);

            myDatabase.execSQL("DELETE FROM stories");
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS stories (year INTEGER(4),headline VARCHAR, id INTEGER PRIMARY KEY)");

            Cursor c = myDatabase.rawQuery("SELECT * FROM stories", null);
            int yearIndex = c.getColumnIndex("year");
            int headlineIndex = c.getColumnIndex("headline");
            int idIndex = c.getColumnIndex("id");
            c.moveToFirst();

            do
            {
                events.put(c.getString(yearIndex),c.getString(headlineIndex));
                Log.i("Logged Year", c.getString(yearIndex));
                Log.i("Logged Headline", c.getString(headlineIndex));
                Log.i("Logged Id", c.getInt(idIndex) + "");
            } while (c.moveToNext());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
