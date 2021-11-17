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

    @Query("Select count(*) FROM nurse_table where loginID = :loginID and password = :password")
    LiveData<Integer> verifyUser(String loginID, String password);

    @Query("Select * FROM nurse_table where loginID = :loginID")
    LiveData<Nurse> getByLoginID(String loginID);

    @Query("Select * FROM nurse_table")
    LiveData<List<Nurse>> getAllNurses();
}

