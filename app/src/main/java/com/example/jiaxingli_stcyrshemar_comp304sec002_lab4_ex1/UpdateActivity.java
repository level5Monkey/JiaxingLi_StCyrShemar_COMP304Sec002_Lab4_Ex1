package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import static com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1.LoginActivity.MY_PREFS_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    private EditText nurseid;
    private EditText patientid;
    private EditText BPL;
    private EditText BPH;
    private EditText TEMP;
    private Button Update;
    private Test test;
    private TestViewModel testmodel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        SharedPreferences sharedPref = UpdateActivity.this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);

        String nurseIDValue = sharedPref.getString("nurseID", "Nurse ID");

        nurseid = (EditText) findViewById(R.id.editNurseID);
        patientid = (EditText) findViewById(R.id.editUpdatePatientID);
        BPL= (EditText) findViewById(R.id.editUpdateBPL);
        BPH = (EditText) findViewById(R.id.editUpdateBPH);
        TEMP = (EditText) findViewById(R.id.editUpdateTemp);
        Update = (Button) findViewById(R.id.buttonUpdateTest);


        nurseid.setText(nurseIDValue);
        patientid.setText(test.getPatientID());
        BPH.setText(test.getBPH());
        BPL.setText(test.getBPL());
        TEMP.setText((int) test.getTemperature());

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int testidvalue = Integer.parseInt(testid.getText().toString());
                if(nurseid.getText().toString().length() != 0 && patientid.getText().toString().length() != 0
                        && BPL.getText().toString().length() != 0 && BPH.getText().toString().length() != 0
                        && TEMP.getText().toString().length() != 0 ) {
                    int nurseidvalue = Integer.parseInt(nurseid.getText().toString());
                    int patientidvalue = Integer.parseInt(patientid.getText().toString());
                    String BPLvalue = BPL.getText().toString();
                    String BPHvalue = BPH.getText().toString();
                    double tempvalue = Double.parseDouble(TEMP.getText().toString());
                    testmodel.update(new Test(patientidvalue, nurseidvalue, BPLvalue, BPHvalue, tempvalue));
                    Toast.makeText(UpdateActivity.this, "Test Created", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(UpdateActivity.this,"Please ensure there are no null values",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



}