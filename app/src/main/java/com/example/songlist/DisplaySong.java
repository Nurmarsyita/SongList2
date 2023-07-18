package com.example.songlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplaySong extends AppCompatActivity {

    ListView lv;
    ArrayList<Songs> alSongs;
    ArrayList<Songs> filteredSongList;
    Button btn5Stars;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_song);

        lv = findViewById(R.id.lv);
        btn5Stars = findViewById(R.id.btn5Stars);

        DBHelper db = new DBHelper(DisplaySong.this);
        alSongs = db.getSongs();
        db.close();

        adapter = new CustomAdapter(this, R.layout.row, alSongs);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs target = alSongs.get(position);

                Intent intent = new Intent(DisplaySong.this, UpdateActivity.class);
                intent.putExtra("data", target);
                startActivity(intent);
            }
        });

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                filteredSongList = new ArrayList<>();
                for (int i = 0; i < alSongs.size(); i++) {
                    if (alSongs.get(i).getStars() == 5) {
                        filteredSongList.add(alSongs.get(i));
                    }
                }

                adapter = new CustomAdapter(DisplaySong.this, R.layout.row, filteredSongList);
                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        DBHelper dbh = new DBHelper(DisplaySong.this);
        alSongs.clear();
        alSongs.addAll(dbh.getSongs());
//        aaSong.notifyDataSetChanged();

        if (btn5Stars.isActivated()) {
            filteredSongList = new ArrayList<>();
            for (int i = 0; i < alSongs.size(); i++) {
                if (alSongs.get(i).getStars() == 5) {
                    filteredSongList.add(alSongs.get(i));
                }
            }
            adapter = new CustomAdapter(DisplaySong.this, R.layout.row, filteredSongList);
            lv.setAdapter(adapter);
        } else {
            adapter = new CustomAdapter(DisplaySong.this, R.layout.row, alSongs);
            lv.setAdapter(adapter);
        }

        adapter.notifyDataSetChanged();
    }
}