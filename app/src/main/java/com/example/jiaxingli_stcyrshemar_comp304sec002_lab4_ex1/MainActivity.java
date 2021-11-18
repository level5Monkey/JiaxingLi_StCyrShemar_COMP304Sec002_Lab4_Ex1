package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button addtest;
private  Button viewtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentPatientInfo = new Intent(this, PatientInfoActivity.class);
        Button btnViewPatient = (Button) findViewById(R.id.btnViewPatient);
        addtest = (Button) findViewById(R.id.btnAddTest);
        viewtest = (Button) findViewById(R.id.btnViewTest);

        viewtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewTestActivity.class);
                startActivity(intent);
            }
        });
        addtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
        btnViewPatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentPatientInfo);
            }
        });

        Intent intentPatient = new Intent(this, PatientActivity.class);
        Button btnAddPatient = (Button) findViewById(R.id.btnAddPatient);
        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentPatient);
            }
        });
    }


}