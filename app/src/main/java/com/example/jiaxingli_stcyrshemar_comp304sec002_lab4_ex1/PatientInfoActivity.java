package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import java.util.List;

public class PatientInfoActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;
    private TextView textViewPatientInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        textViewPatientInfo = findViewById(R.id.textViewPatientInfo);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);

        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> result) {
                String output="";
                for(Patient patient : result) {
                    output+= "Patient ID: " + patient.getPatientID() +", Patient First Name: " + patient.getFirstName() +", Patient Last Name: " + patient.getLastName() +", Patient Department: " + patient.getDepartment() +", Patient Nurse ID: " + patient.getNurseID() +", Patient Room: " + patient.getRoom() +"\n";
                }
                textViewPatientInfo.setText(output);
            }
        });
    }
}