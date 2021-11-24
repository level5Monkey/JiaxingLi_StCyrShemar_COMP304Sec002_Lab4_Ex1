package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import static com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1.LoginActivity.MY_PREFS_NAME;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class PatientActivity extends AppCompatActivity {
    private PatientViewModel patientViewModel;
    private NurseViewModel nurseViewModel;
    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private Spinner department;
    private TextInputEditText nurseID;
    private TextInputEditText room;
    private int patientID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);


        Button btnCreatePatient = (Button) findViewById(R.id.btnCreatePatient);
        btnCreatePatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createPatientButton(v);
            }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(PatientInfoActivity.EXTRA_MESSAGE);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        nurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);
        patientID = -1;

        if(message != null) {

            btnCreatePatient.setText("Update");
            patientID = Integer.valueOf(message);
            TextInputEditText TextInputFirstName=(TextInputEditText)findViewById(R.id.TextInputFirstName);
            TextInputEditText TextInputLastName=(TextInputEditText)findViewById(R.id.TextInputLastName);
            TextInputEditText TextInputRoom=(TextInputEditText)findViewById(R.id.TextInputRoom);

            patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
                @Override
                public void onChanged(@Nullable List<Patient> result) {
                    for(Patient patient : result) {
                        if (patient.getPatientID() == Integer.valueOf(message)) {
                            TextInputFirstName.setText(patient.getFirstName());
                            TextInputLastName.setText(patient.getLastName());
                            TextInputRoom.setText(patient.getRoom());
                        }
                    }
                }
            });

        }

        SharedPreferences sharedPref = PatientActivity.this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String nurseIDValue = sharedPref.getString("nurseID", "Nurse ID");

        TextInputEditText nurseID=(TextInputEditText)findViewById(R.id.TextInputNurseID);
        nurseID.setText(nurseIDValue);

        department = (Spinner)findViewById(R.id.SpinnerDepartment);
        StringBuffer departmentName = new StringBuffer();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.departments_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        department.setAdapter(adapter);
        department.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch(pos)
                {
                    case 0:
                        departmentName.append("Emergency");
                        break;
                    case 1:
                        departmentName.append("Cardiology");
                        break;
                    case 2:
                        departmentName.append("Nursing");
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }

    public void createPatientButton(View view) {
        firstName = (TextInputEditText)findViewById(R.id.TextInputFirstName);
        lastName = (TextInputEditText)findViewById(R.id.TextInputLastName);
        nurseID = (TextInputEditText)findViewById(R.id.TextInputNurseID);
        room = (TextInputEditText)findViewById(R.id.TextInputRoom);
        department = (Spinner)findViewById(R.id.SpinnerDepartment);

        if (firstName.getText().toString().length() != 0 && lastName.getText().toString().length() != 0
                && department.getSelectedItem().toString().length() != 0 &&
                nurseID.getText().toString().length() != 0 &&
                room.getText().toString().length() != 0) {
            String firstNameValue = firstName.getText().toString();
            String lastNameValue = lastName.getText().toString();
            String departmentValue = department.getSelectedItem().toString();
            int nurseIDValue = Integer.parseInt(nurseID.getText().toString());
            String roomValue = room.getText().toString();

            if (patientID != -1) {
                patientViewModel.update(patientID, firstNameValue, lastNameValue, departmentValue, roomValue);
                Toast.makeText(PatientActivity.this, "Patient updated", Toast.LENGTH_SHORT).show();
            } else {
                patientViewModel.insert(new Patient(firstNameValue, lastNameValue, departmentValue, nurseIDValue, roomValue));
                Toast.makeText(PatientActivity.this, "Patient created", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(PatientActivity.this, PatientInfoActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(PatientActivity.this, "Please ensure there are no null values", Toast.LENGTH_SHORT).show();
        }
    }
}
