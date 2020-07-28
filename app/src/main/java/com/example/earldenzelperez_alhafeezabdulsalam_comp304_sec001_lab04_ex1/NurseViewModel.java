package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseViewModel extends AndroidViewModel
{
    // calling repository tasks and
    // sending the results to the Activity
    private NurseRepository nurseRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Nurse>> allNurses;
    //
    public NurseViewModel(@NonNull Application application)
    {
        super(application);
        nurseRepository = new NurseRepository(application);
        insertResult =  nurseRepository.getInsertResult();
        allNurses =  nurseRepository.getAllNurses();
    }
    //calls repository to insert a person
    public void insert(Nurse nurse) {
        nurseRepository.insert(nurse);
    }
    //gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    //returns query results as live data object
    LiveData<List<Nurse>> getAllNurses() { return allNurses; }
}
