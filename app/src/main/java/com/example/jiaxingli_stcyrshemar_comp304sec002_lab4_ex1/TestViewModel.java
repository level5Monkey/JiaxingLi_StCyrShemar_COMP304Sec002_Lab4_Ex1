package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TestViewModel extends AndroidViewModel {
    private TestRepository testRepository;
    private LiveData<List<Test>> allTests;

    public TestViewModel(Application application) {
        super((application));
        testRepository = new TestRepository(application);
        allTests = testRepository.getAllTests();
    }

    public  LiveData<Test> findByTestID(int testID) {return testRepository.findbyTestID(testID); }

    public void insert(Test test) { testRepository.insert(test); }

    public LiveData<List<Test>> getAllTests() { return allTests; }
}

