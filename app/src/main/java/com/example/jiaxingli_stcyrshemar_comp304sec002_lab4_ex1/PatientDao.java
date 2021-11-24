package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface PatientDao {

    @Insert
    void insert(Patient patient);

    @Query("UPDATE patient_table SET firstName = :fisrtName, lastName = :lastName, Department = :Department, Room = :Room where patientID = :patientID")
    void updateByPatientID(int patientID, String fisrtName, String lastName, String Department, String Room);

    @Update
    void update(Patient patient);

    @Delete
    void delete(Patient patient);

    @Query("DELETE FROM patient_table")
    void deleteAll();

    @Query("Select * FROM patient_table where patientID = :patientID")
    LiveData<Patient> getByPatientID(int patientID);

    @Query("Select FirstName FROM patient_table where patientID = :patientID")
    String getFirstNameByPatientID(int patientID);

    @Query("Select LastName FROM patient_table where patientID = :patientID")
    String getLastNameByPatientID(int patientID);

    @Query("Select Room FROM patient_table where patientID = :patientID")
    String getRoomByPatientID(int patientID);

    @Query("Select * FROM patient_table")
    LiveData<List<Patient>> getAllPatients();
}

