package com.example.veronica.historyfanatics;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ShowsActivity extends AppCompatActivity
{
    public boolean isFromShows=true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows);

        WebView webView = (WebView)findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://www.history.com/shows");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        inflater.inflate(R.menu.save_menu,menu);
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
            case R.id.save:
                new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Watch later?")
                        .setMessage("Got something to watch later?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
//                                WatchListFragment fragment = new WatchListFragment();
//                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                                transaction.replace(R.id.watch_list_id, fragment);
//                                transaction.commit();
                                Intent intent1 = new Intent(getApplicationContext(),SettingsActivity.class);
                                intent1.putExtra("fromShows",isFromShows);
                                startActivity(intent1);
                            }
                        })
                        .setNegativeButton("No", null).show();
                Log.i("Logging","Save story");
                break;
            default:
                Log.i("Logging","Error Today");
                break;
        }
        return true;
    }

}
