package com.example.jiaxingli_stcyrshemar_comp304sec002_lab4_ex1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {
    private NurseRepository nurseRepository;
    private LiveData<Integer> insertResult;
    private LiveData<Nurse> selectedNurses;
    private LiveData<List<Nurse>> allNurses;

    public NurseViewModel(Application application) {
        super((application));
        nurseRepository = new NurseRepository(application);
        insertResult = nurseRepository.getInsertResult();
        allNurses = nurseRepository.getAllNurses();
    }

    public LiveData<Nurse> findByLoginID(String loginID) { return nurseRepository.findByLoginID(loginID); }

    public void insert(Nurse nurse) { nurseRepository.insert(nurse); }

    public LiveData<Integer> getInsertResult() { return insertResult; }

    public LiveData<Integer> getVerifyResult(String editTextUserID, String editTextPassword) {
        return nurseRepository.verifyUser(editTextUserID, editTextPassword);
    }

    public LiveData<List<Nurse>> getAllNurses() { return allNurses; }
}

