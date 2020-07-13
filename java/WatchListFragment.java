package com.example.veronica.historyfanatics;


import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 */
public class WatchListFragment extends Fragment
{
    EditText inputShow;
    Button addShow;
    ArrayList<String> showList;
    ArrayAdapter adapter;
    ListView showView;
    String input="";

    SQLiteDatabase myDatabase;

    public WatchListFragment()
    {
        // Required empty public constructor
    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_watch_list, container, false);

        inputShow = (EditText)rootView.findViewById(R.id.insert_show);
        showView = (ListView)rootView.findViewById(R.id.watch_list);
        addShow = (Button)rootView.findViewById(R.id.add_button);

        addShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Logging","add onclick");
                setAddShow();
            }
        });


        showView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {
                new AlertDialog.Builder(getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Delete")
                        .setMessage("Delete show from list?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String show = showList.get(position);
                                myDatabase.execSQL("DELETE FROM shows WHERE name='" + show + "'");
                                showList.remove(showList.get(position));
                            }
                        })
                        .setNegativeButton("No", null).show();
            }
        });
        return inflater.inflate(R.layout.fragment_watch_list, container, false);
    }

    public void setAddShow()
    {
        Log.i("Logging","Adding show");
        input = inputShow.getText().toString();
        if(input.equals(""))
        {
            Toast.makeText(getContext(), "Please enter a valid value", Toast.LENGTH_SHORT).show();
            createDB();
        }
        else
        {
            myDatabase.execSQL("INSERT INTO shows (name) VALUES ('" + input + "')");
            showList.add(input);
            adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, showList);
            showView.setAdapter(adapter);
            Log.i("Logging",input+" added");
            input = "";
            inputShow.setText(input);
        }
    }

    public void createDB()
    {
        try
        {
            myDatabase = getActivity().openOrCreateDatabase("shows", getActivity().MODE_PRIVATE, null);
            Log.i("Logging", "shows database opened or created");
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS shows (name VARCHAR, id INTEGER PRIMARY KEY)");
            Log.i("Logging","Database created");
            Cursor c = myDatabase.rawQuery("SELECT * FROM shows", null);
            Log.i("Logging","cursor select");
            int nameIndex = c.getColumnIndex("name");
            int idIndex = c.getColumnIndex("id");
            Log.i("Logging","index");
            c.moveToFirst();
            Log.i("Logging", "cursor read");
            showList = new ArrayList<>();
            do
            {
                showList.add(c.getString(nameIndex));
                Log.i("Logging","show added");
                adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, showList);
                showView.setAdapter(adapter);
                Log.i("Logged Name", c.getString(nameIndex));
                Log.i("Logged Id", c.getInt(idIndex) + "");
            } while (c.moveToNext());

        }catch (Exception e){
            e.printStackTrace();
            Log.i("Logging","Database error");
        }
    }
}
