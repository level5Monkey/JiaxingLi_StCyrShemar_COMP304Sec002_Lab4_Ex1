package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TestRepository {

    public TestDao testDao;
    private LiveData<List<Test>> allTests;

    public TestRepository(Application application)
    {
        TestDatabase db = TestDatabase.getDatabase(application);
        testDao = db.testDao();
        allTests = testDao.getAllTests();
    }

    public LiveData<List<Test>> getAllTests() {return allTests; }

    public void insert(Test test) {
        TestDatabase.databaseWriteExecutor.execute(() -> {
            testDao.insert(test);
        });
    }
    public void delete(Test test)
    {
        TestDatabase.databaseWriteExecutor.execute(()->{
            testDao.delete(test);
                }
                );
    }
    public void update(Test test)
    {
        TestDatabase.databaseWriteExecutor.execute(()->{
                    testDao.update(test);
                }
        );
    }

    public LiveData<Test> findbyTestID(int testID) {return testDao.getByTestID(testID); }
}
