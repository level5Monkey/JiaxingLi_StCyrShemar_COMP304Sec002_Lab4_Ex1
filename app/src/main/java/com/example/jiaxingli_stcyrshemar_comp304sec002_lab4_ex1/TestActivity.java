package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
   // private EditText testid;
    private EditText nurseid;
    private EditText patientid;
    private EditText BPL;
    private EditText BPH;
    private EditText Temp;
    private Button Next;
    private TestViewModel testmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testmodel = new ViewModelProvider(this).get(TestViewModel.class);

        //testid = (EditText) findViewById(R.id.editTestID);
        nurseid = (EditText) findViewById(R.id.editNurseID);
        patientid = (EditText) findViewById(R.id.editPatientID);
        BPL = (EditText) findViewById(R.id.editBPL);
        BPH = (EditText) findViewById(R.id.editBPH);
        Temp = (EditText) findViewById(R.id.editTemp);
        Next = (Button) findViewById(R.id.buttonViewTest);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //int testidvalue = Integer.parseInt(testid.getText().toString());
                if(nurseid.getText().toString().length() != 0 && patientid.getText().toString().length() != 0
                        && BPL.getText().toString().length() != 0 && BPH.getText().toString().length() != 0
                        && Temp.getText().toString().length() != 0 ) {
                    int nurseidvalue = Integer.parseInt(nurseid.getText().toString());
                    int patientidvalue = Integer.parseInt(patientid.getText().toString());
                    String BPLvalue = BPL.getText().toString();
                    String BPHvalue = BPH.getText().toString();
                    double tempvalue = Double.parseDouble(Temp.getText().toString());
                    testmodel.insert(new Test(patientidvalue, nurseidvalue, BPLvalue, BPHvalue, tempvalue));
                    Toast.makeText(TestActivity.this, "Test Created", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(TestActivity.this,"Please ensure there are no null values",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}