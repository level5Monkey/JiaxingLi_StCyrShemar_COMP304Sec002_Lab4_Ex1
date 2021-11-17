package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.content.Context;

import androidx.room.Room;

public class NurseDatabaseAccessor {

    private static NurseDatabase NurseDatabaseInstance;
    private static final String  NURSE_DB_NAME = "nurse_database";

    private NurseDatabaseAccessor() {
    }

    public static NurseDatabase getInstance(Context context) {
        if (NurseDatabaseInstance == null) {
            NurseDatabaseInstance = Room.databaseBuilder(context, NurseDatabase.class, NURSE_DB_NAME).build();
        }
        return NurseDatabaseInstance;
    }
}
