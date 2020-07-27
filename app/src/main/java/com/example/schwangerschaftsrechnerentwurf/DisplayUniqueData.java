package com.example.schwangerschaftsrechnerentwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayUniqueData extends AppCompatActivity {

    long ListViewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_unique_data);

        Intent thisIntent = getIntent();
        ListViewID = thisIntent.getLongExtra("ListViewID", 0);

        TextView Display_ID = findViewById(R.id.display_id);
        Display_ID.setText(String.valueOf(ListViewID));
    }
}
