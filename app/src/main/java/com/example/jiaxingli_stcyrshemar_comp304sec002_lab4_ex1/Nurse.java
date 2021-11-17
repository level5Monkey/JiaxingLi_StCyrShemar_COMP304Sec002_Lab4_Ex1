package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nurse_table")
public class Nurse {

    @PrimaryKey(autoGenerate = true)
    private int nurseID;

    @NonNull
    private String loginID;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String department;

    @NonNull
    private String password;

    public Nurse() {}

    public Nurse(@NonNull String loginID, @NonNull String firstName, @NonNull String lastName, @NonNull String department, @NonNull String password) {
        this.loginID = loginID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.password = password;
    }

    public void setNurseID(int nurseID) {this.nurseID = nurseID;}

    public void setLoginID(String loginID) {this.loginID = loginID;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setDepartment(String department) {this.department = department;}

    public void setPassword(String password) {this.password = password;}

    public int getNurseID() {
        return nurseID;
    }

    public String getLoginID() {
        return loginID;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    @NonNull
    public String getDepartment() {
        return department;
    }

    @NonNull
    public String getPassword() { return password; }
}