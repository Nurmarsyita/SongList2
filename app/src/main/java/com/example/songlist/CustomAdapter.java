package com.example.songlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Songs> todolist;

    public CustomAdapter(@NonNull Context context, int resource,
                         ArrayList<Songs> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        todolist = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvSingers = rowView.findViewById(R.id.textViewSingers);
        TextView tvYearsReleased = rowView.findViewById(R.id.textViewYearsReleased);
        TextView tvStars = rowView.findViewById(R.id.textViewStars);

        // Obtain the Android Version information based on the position
        Songs currentList = todolist.get(position);

        // Set values to the TextView to display the corresponding info
        tvTitle.setText(currentList.getTitle());
        tvSingers.setText(currentList.getSingers());
        tvYearsReleased.setText(String.valueOf(currentList.getYear()));
        tvStars.setText(currentList.starsShow());

        return rowView;
    }
}
