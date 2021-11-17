package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "test_table")
public class Test {

    @PrimaryKey(autoGenerate = true)
    private int testID;

    @NonNull
    private int patientID;

    @NonNull
    private int nurseID;

    @NonNull
    private String BPL;

    @NonNull
    private String BPH;

    @NonNull
    private double temperature;

    public Test(@NonNull int patientID, @NonNull int nurseID, @NonNull String BPL, @NonNull String BPH, @NonNull double temperature) {
        this.patientID = patientID;
        this.nurseID = nurseID;
        this.BPL = BPL;
        this.BPH = BPH;
        this.temperature = temperature;
    }

    public void setTestID(int testID) {this.testID = testID;}

    public int getTestID() {
        return testID;
    }

    @NonNull
    public int getPatientID() {
        return patientID;
    }

    @NonNull
    public int getNurseID() {
        return nurseID;
    }

    @NonNull
    public String getBPL() {
        return BPL;
    }

    @NonNull
    public String getBPH() {
        return BPH;
    }

    @NonNull
    public double getTemperature() {
        return temperature;
    }


}
