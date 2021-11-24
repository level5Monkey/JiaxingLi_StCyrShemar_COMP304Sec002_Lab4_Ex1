package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class PatientInfoActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.Jiaxingli_COMP304Sec002_Lab1_Ex01.MESSAGE";
    private PatientViewModel patientViewModel;
    //private TextView textViewPatientInfo;
    private RecyclerView recyclerViewPatientInfo;
    private List<Patient> patients;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

        patients = new ArrayList<Patient>();

        final CustomAdapter adapter = new CustomAdapter(new CustomAdapter.PatientDiff());

        recyclerViewPatientInfo = findViewById(R.id.recyclerViewPatientInfo);
        recyclerViewPatientInfo.setAdapter(adapter);
        recyclerViewPatientInfo.setLayoutManager(new LinearLayoutManager(this));

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);

        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> result) {
                for(Patient patient : result) {
                    patients.add(patient);
                }
                adapter.submitList(patients);
            }
        });

        recyclerViewPatientInfo.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerViewPatientInfo ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(PatientInfoActivity.this, PatientActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, ""+adapter.getCurrentList().get(position).getPatientID());
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Intent intent = new Intent(PatientInfoActivity.this, PatientActivity.class);
                        intent.putExtra(EXTRA_MESSAGE, ""+adapter.getCurrentList().get(position).getPatientID());
                        startActivity(intent);
                    }
                })
        );

    }
}