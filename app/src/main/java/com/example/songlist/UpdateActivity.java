package com.example.songlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    TextView tvSongTitle, tvSingers, tvYear, tvStars, tvID;
    EditText etSongTitle, etSingers, etYear, etID;
    RadioGroup rgStars;
    Button btnUpdate, btnDelete, btnCancel;
    Songs data;
    RadioButton rbStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        tvSongTitle = findViewById(R.id.tvSongTitle);
        tvSingers = findViewById(R.id.tvSingers);
        tvYear = findViewById(R.id.tvYear);
        tvStars = findViewById(R.id.tvStars);
        tvID = findViewById(R.id.tvID);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        etID = findViewById(R.id.etID);

        rgStars = findViewById(R.id.rgStars);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Songs) i.getSerializableExtra("data");

        etID.setFocusable(false);
        etID.setText(String.valueOf(data.getId()));
        etSongTitle.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));

        int selected = data.getStars();

        if (selected == 1) {
            rbStar = findViewById(R.id.star1);
            rbStar.setChecked(true);
        } else if (selected == 2){
            rbStar = findViewById(R.id.star2);
            rbStar.setChecked(true);

        } else if (selected == 3) {
            rbStar = findViewById(R.id.star3);
            rbStar.setChecked(true);

        } else if (selected == 4) {
            rbStar = findViewById(R.id.star4);
            rbStar.setChecked(true);

        } else if (selected == 5) {
            rbStar = findViewById(R.id.star5);
            rbStar.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(UpdateActivity.this);
                data.setTitle(etSongTitle.getText().toString());
                data.setSingers(etSingers.getText().toString());
                data.setYears(Integer.parseInt(etYear.getText().toString()));

                int selected = rgStars.getCheckedRadioButtonId();
                rbStar = findViewById(selected);
                data.setStars(Integer.parseInt(rbStar.getText().toString()));
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(UpdateActivity.this);
                dbh.deleteSong(data.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}