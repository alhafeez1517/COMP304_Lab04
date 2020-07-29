package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MedicalTestViewModel extends AndroidViewModel
{
    // calling repository tasks and
    // sending the results to the Activity
    private MedicalTestRepository medicalTestRepository;
    //
    public MedicalTestViewModel(@NonNull Application application)
    {
        super(application);
        medicalTestRepository = new MedicalTestRepository(application);
    }
    //calls repository to insert a person
    public void insert(MedicalTest medicalTest) {
        medicalTestRepository.insert(medicalTest);
    }

    public List<MedicalTest> getAllTestsForPatient(int id){ return medicalTestRepository.getAllTestsForPatient(id); }

}
