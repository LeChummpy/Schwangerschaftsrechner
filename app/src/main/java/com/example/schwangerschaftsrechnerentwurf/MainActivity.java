package com.example.schwangerschaftsrechnerentwurf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    Button mAddPatient;
    Cursor data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        Values.PatientDB = new DatabseHandler(this);

        mListView = (ListView)findViewById(R.id.ListView);
        mAddPatient = (Button)findViewById(R.id.addPatient);
        mAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), create_new_Patient_activity.class));
                finish();
            }
        });

        updateList();
    }

    public void updateList(){
        data = Values.PatientDB.getContent();
        ArrayList<String> mListView_Data = new ArrayList<>();
        while (data.moveToNext()){
            mListView_Data.add(data.getString(1) + "   " + data.getString(2) + "        " + data.getString(3) + "        " + data.getString(4) );
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListView_Data);
        mListView.setAdapter(adapter);
    }
}
