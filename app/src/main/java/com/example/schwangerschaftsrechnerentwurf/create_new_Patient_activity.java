package com.example.schwangerschaftsrechnerentwurf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class create_new_Patient_activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    public String first_name;
    public String sure_name;
    public int adop;
    public String dola;

    public int Year;
    public  int Month;
    public int Day;

    public EditText Enter_firstName;
    public EditText Enter_sureName;
    public EditText Enter_adop;
    public EditText Enter_Dola;
    public Button increaseAdop;
    public Button decreaseAdop;
    public Button submit;
    public Button ClickEnterDate;
    public Button Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new__patient_activity);
        this.getSupportActionBar().hide();
        Enter_firstName = findViewById(R.id.Enter_firstName);
        Enter_sureName = findViewById(R.id.Enter_sureName);
        Enter_adop = findViewById(R.id.Enter_adop);
        Enter_Dola = findViewById(R.id.Enter_dola);
        increaseAdop = findViewById(R.id.ButtonIncreaseAdop);
        decreaseAdop = findViewById(R.id.ButtonDecreaseAdop);
        ClickEnterDate = findViewById(R.id.Button_Enter_Date);
        submit = findViewById(R.id.ButtonSubmit);
        Cancel = findViewById(R.id.buttonChancel);

        adop = 0;
        Enter_adop.setText(String.valueOf(adop));

        increaseAdop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adop++;
                if (adop>0)Enter_adop.setText("+" + String.valueOf(adop));
                else Enter_adop.setText(String.valueOf(adop));
            }
        });

        decreaseAdop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adop--;
                if (adop>0)Enter_adop.setText("+" + String.valueOf(adop));
                else Enter_adop.setText(String.valueOf(adop));
            }
        });

        ClickEnterDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "day of the last amenorrhea");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name = Enter_firstName.getText().toString();
                String surename = Enter_sureName.getText().toString();
                String adop = Enter_adop.getText().toString();
                String dola = Enter_Dola.getText().toString();

                if (helpful_functions.checkWetherStringContainsSigns(first_name) && helpful_functions.checkWetherStringContainsSigns(surename)
                    && helpful_functions.checkWetherStringContainsSigns(adop) && helpful_functions.checkWetherStringContainsSigns(dola)){

                    Values.PatientDB.insertData(first_name, surename, adop, dola);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

                else {
                    Toast.makeText(create_new_Patient_activity.this, "Please fill in all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Year = year;
        Month = month;
        Day = dayOfMonth;
        Enter_Dola.setText(Day + "/"  + Month + "/" + Year);
    }
}
