package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ViewTestActivity extends AppCompatActivity {
    private TextView testid;
    private TextView patientid;
    private TextView nurseid;
    private TextView BPL;
    private TextView BPH;
    private TextView TEMP;
    private Test test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);

        testid = (TextView) findViewById(R.id.textViewTestID);
        patientid = (TextView) findViewById(R.id.textViewPatientID);
        nurseid = (TextView) findViewById(R.id.textViewNurseID);
        BPL = (TextView) findViewById(R.id.textViewBPL);
        BPH = (TextView) findViewById(R.id.textViewBPH);
        TEMP = (TextView) findViewById(R.id.textViewTemp);

       // testid.setText("TestID: "+test.getTestID());
       //patientid.setText("PatientID: "+test.getPatientID());
       //nurseid.setText("NurseID: "+test.getNurseID());
        //BPL.setText("BPL: "+test.getBPL());
        //BPH.setText("BPH: "+test.getBPH());
        //TEMP.setText("Temperature: "+test.getTemperature());









    }
}