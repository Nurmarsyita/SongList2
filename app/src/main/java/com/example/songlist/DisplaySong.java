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
    ArrayList<Songs> al;
    ArrayAdapter aa;
    Button btn5Stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_song);

        lv = findViewById(R.id.lv);
        btn5Stars = findViewById(R.id.btn5Stars);

        al = new ArrayList<Songs>();
        aa = new ArrayAdapter<Songs>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        DBHelper dbh = new DBHelper(DisplaySong.this);
        al.clear();
        al.addAll(dbh.getSongs());
        aa.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs target = al.get(position);

                Intent intent = new Intent(DisplaySong.this, UpdateActivity.class);
                intent.putExtra("data", target);
                startActivity(intent);
            }
        });

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper dbh = new DBHelper(DisplaySong.this);
                al.clear();
                int filterText = 5;
                al.addAll(dbh.getSongsStar(filterText));

                aa.notifyDataSetChanged();
            }
        });
    }
        @Override
    protected void onResume() {
        super.onResume();

        DBHelper dbh = new DBHelper(DisplaySong.this);
        al.clear();
        al.addAll(dbh.getSongs());
        aa.notifyDataSetChanged();
    }
}