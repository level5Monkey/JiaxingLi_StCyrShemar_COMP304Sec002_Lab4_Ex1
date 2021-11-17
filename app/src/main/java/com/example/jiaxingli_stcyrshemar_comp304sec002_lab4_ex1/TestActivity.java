package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {
    private EditText testid;
    private EditText nurseid;
    private EditText patientid;
    private EditText BPL;
    private EditText BPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testid = (EditText) findViewById(R.id.editTestID);
        nurseid = (EditText) findViewById(R.id.editNurseID);
        patientid = (EditText) findViewById(R.id.editPatientID);
        BPL = (EditText) findViewById(R.id.editBPL);
        BPH = (EditText) findViewById(R.id.editBPH);



    }
}