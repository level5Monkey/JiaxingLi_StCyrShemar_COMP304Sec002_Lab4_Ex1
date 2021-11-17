package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NurseDao {

    @Insert
    void insert(Nurse nurse);

    @Update
    void update(Nurse nurse);

    @Delete
    void delete(Nurse nurse);

    @Query("DELETE FROM nurse_table")
    void deleteAll();

    @Query("Select count(*) FROM nurse_table where nurseID = :nurseID and password = :password")
    LiveData<Integer> verifyUser(String nurseID, String password);

    @Query("Select * FROM nurse_table where nurseID = :nurseID")
    LiveData<Nurse> getByNurseID(String nurseID);

    @Query("Select * FROM nurse_table")
    LiveData<List<Nurse>> getAllNurses();
}

