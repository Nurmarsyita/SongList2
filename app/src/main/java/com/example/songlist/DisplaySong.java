package com.example.songlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplaySong extends AppCompatActivity {

    ListView lv;

    ArrayList<Songs> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_song);

        lv = findViewById(R.id.lv);

        al = new ArrayList<Songs>();
        aa = new ArrayAdapter<Songs>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        DBHelper dbh = new DBHelper(DisplaySong.this);
        al.clear();
        al.addAll(dbh.getSongs());
        aa.notifyDataSetChanged();
//
//        String txt = "";
//        for (int i = 0; i < dTitle.size(); i++) {
//            Log.d("Database Content", i + ". " + dTitle.get(i) + dSinger.get(i) + dYear.get(i) + dStar.get(i));
//            txt += i + ". " + "\nSong Title: " + dTitle.get(i) + dSinger.get(i) + dYear.get(i)
//                    + dStar.get(i);
//        }

    }
}