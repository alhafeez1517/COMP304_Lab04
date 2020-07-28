package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PatientViewModel extends AndroidViewModel
{
    // calling repository tasks and
    // sending the results to the Activity
    private PatientRepository patientRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<Patient>> allPatients;
    //
    public PatientViewModel(@NonNull Application application)
    {
        super(application);
        patientRepository = new PatientRepository(application);
        insertResult =  patientRepository.getInsertResult();
        allPatients =  patientRepository.getAllPatients();
    }
    //calls repository to insert a person
    public void insert(Patient person) {
        patientRepository.insert(person);
    }
    //gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }
    //returns query results as live data object
    LiveData<List<Patient>> getAllPatients() { return allPatients; }
}
