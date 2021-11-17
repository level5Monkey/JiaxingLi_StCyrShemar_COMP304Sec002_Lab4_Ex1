package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextNurseID;
    private EditText editTextPassword;
    private Nurse nurse;
    private NurseViewModel nurseViewModel;
    private String nurseID;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                editTextNurseID = findViewById(R.id.editTextNurseID);
                nurseID = editTextNurseID.getText().toString();
                editTextPassword = findViewById(R.id.editTextPassword);
                userPassword = editTextPassword.getText().toString();

                if (!nurseID.isEmpty() && !userPassword.isEmpty()) {
                    nurseViewModel.getVerifyResult(nurseID, userPassword).observe(LoginActivity.this, result -> {
                        if (result == 1) {
                            Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intentMain);
                        } else {
                            Toast.makeText(LoginActivity.this, "Wrong userid or password!", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intentRegister = new Intent(this, RegisterActivity.class);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentRegister);
            }
        });
    }
}