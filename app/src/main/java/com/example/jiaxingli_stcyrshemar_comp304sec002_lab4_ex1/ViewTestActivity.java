package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ViewTestActivity extends AppCompatActivity {
    private TextView testid;
    private TextView patientid;
    private TextView nurseid;
    private TextView BPL;
    private TextView BPH;
    private TextView TEMP;
    private  TextView textviewinfo;
    private TestViewModel testview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);

      //  testid = (TextView) findViewById(R.id.textViewTestID);
      //  patientid = (TextView) findViewById(R.id.textViewPatientID);
       // nurseid = (TextView) findViewById(R.id.textViewNurseID);
       // BPL = (TextView) findViewById(R.id.textViewBPL);
       // BPH = (TextView) findViewById(R.id.textViewBPH);
       // TEMP = (TextView) findViewById(R.id.textViewTemp);
        textviewinfo = (TextView) findViewById(R.id.textViewTestInfo);

        testview = new ViewModelProvider(this).get(TestViewModel.class);

        testview.getAllTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                String output="";
                for(Test test: tests){
                    output+= "Test ID: " + test.getTestID() + ", Patient ID: " + test.getPatientID() +
                            ", Nurse ID: " + test.getNurseID() + ", BPL: "+
                    test.getBPL()+ ", BPH: " + test.getBPH()+
                    ", Temperature: " + test.getTemperature()+"\n";
                }
                textviewinfo.setText(output);
            }
        });
       // testid.setText("TestID: "+test.getTestID());
       //patientid.setText("PatientID: "+test.getPatientID());
       //nurseid.setText("NurseID: "+test.getNurseID());
        //BPL.setText("BPL: "+test.getBPL());
        //BPH.setText("BPH: "+test.getBPH());
        //TEMP.setText("Temperature: "+test.getTemperature());

    }
}