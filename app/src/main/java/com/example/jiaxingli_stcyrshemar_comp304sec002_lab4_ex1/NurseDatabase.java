package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Nurse.class}, version = 1, exportSchema = false)
public abstract class NurseDatabase extends RoomDatabase {

    public abstract NurseDao nurseDao();

    private static volatile NurseDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static NurseDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NurseDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NurseDatabase.class, "nurse_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more patients, just add them.
                //PatientDao dao = INSTANCE.patientDao();
                //dao.deleteAll();
            });
        }
    };
}

