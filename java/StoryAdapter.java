package com.example.veronica.historyfanatics;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Veronica on 5/13/2019.
 */
public class StoryAdapter extends ArrayAdapter<Story>
{
    public StoryAdapter(Activity context, ArrayList<Story> resource)
    {
        super(context, 0,resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listViewItem = convertView;
        if (listViewItem == null)
        {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_events, parent, false);
        }
        Story currentStory = getItem(position);

        TextView year = (TextView) listViewItem.findViewById(R.id.event_year);
        year.setText(currentStory.getYear());

        TextView story = (TextView) listViewItem.findViewById(R.id.event_data);
        story.setText(currentStory.getStory());

        return listViewItem;
    }
}
