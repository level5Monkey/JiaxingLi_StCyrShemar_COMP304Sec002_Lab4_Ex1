package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import static com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1.LoginActivity.MY_PREFS_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class PatientActivity extends AppCompatActivity {
    private PatientViewModel patientViewModel;
    private NurseViewModel nurseViewModel;
    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private Spinner department;
    private TextInputEditText nurseID;
    private TextInputEditText room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        nurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);

        SharedPreferences sharedPref = PatientActivity.this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String nurseIDValue = sharedPref.getString("nurseID", "Nurse ID");

        TextInputEditText nurseID=(TextInputEditText)findViewById(R.id.TextInputNurseID);
        nurseID.setText(nurseIDValue);

        Button btnCreatePatient = (Button) findViewById(R.id.btnCreatePatient);
        btnCreatePatient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createPatientButton(v);
            }
        });

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

        if (firstName.getText().toString().length() != 0 && lastName.getText().toString().length() != 0
                && department.toString().length() != 0 &&
                nurseID.getText().toString().length() != 0 &&
                room.getText().toString().length() != 0) {
            String firstNameValue = firstName.getText().toString();
            String lastNameValue = lastName.getText().toString();
            String departmentValue = department.toString();
            int nurseIDValue = Integer.parseInt(nurseID.getText().toString());
            String roomValue = room.getText().toString();

            patientViewModel.insert(new Patient(firstNameValue, lastNameValue, departmentValue, nurseIDValue, roomValue));
            Toast.makeText(PatientActivity.this, "Patient created", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(PatientActivity.this, "Please ensure there are no null values", Toast.LENGTH_SHORT).show();
        }
    }
}
