package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PatientRepository {

    public PatientDao patientDao;
    private LiveData<List<Patient>> allPatients;

    public PatientRepository(Application application)
    {
        PatientDatabase db = PatientDatabase.getDatabase(application);
        patientDao = db.patientDao();
        allPatients = patientDao.getAllPatients();
    }

    public LiveData<List<Patient>> getAllPatients() {return allPatients; }

    public void insert(Patient patient) {
        PatientDatabase.databaseWriteExecutor.execute(() -> {
            patientDao.insert(patient);
        });
    }

    public void update(int patientID, String fisrtName, String lastName, String Department, String Room) {
        PatientDatabase.databaseWriteExecutor.execute(() -> {
            patientDao.updateByPatientID(patientID, fisrtName, lastName, Department, Room);
        });
    }

    public LiveData<Patient> findbyPatientID(int patientID) {return patientDao.getByPatientID(patientID); }
}
