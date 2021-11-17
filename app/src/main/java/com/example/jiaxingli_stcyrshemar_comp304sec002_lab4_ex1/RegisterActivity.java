package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Nurse nurse;
    private NurseViewModel nurseViewModel;
    private EditText editTextLoginID;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextPassword;
    private EditText editTextDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);

        nurseViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Intent intentLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intentLogin);
                    Toast.makeText(RegisterActivity.this, "New user successfully created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Error creating new user", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editTextLoginID = findViewById(R.id.editTextLoginID);
                String LoginID = editTextLoginID.getText().toString();

                editTextFirstName = findViewById(R.id.editTextFirstName);
                String FirstName = editTextFirstName.getText().toString();

                editTextLastName = findViewById(R.id.editTextLastName);
                String LastName = editTextLastName.getText().toString();

                editTextDepartment = findViewById(R.id.editTextDepartment);
                String Department = editTextDepartment.getText().toString();

                editTextPassword = findViewById(R.id.editTextPassword);
                String Password = editTextPassword.getText().toString();

                if (!Password.isEmpty() && !FirstName.isEmpty() && !LastName.isEmpty() && !Department.isEmpty() && !Password.isEmpty()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            nurse = new Nurse(LoginID, FirstName, LastName, Department, Password);
                            nurseViewModel.insert(nurse);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, "New user successfully created", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                } else {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}