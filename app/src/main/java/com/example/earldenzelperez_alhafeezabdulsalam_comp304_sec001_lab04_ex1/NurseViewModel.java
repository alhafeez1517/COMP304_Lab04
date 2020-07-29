package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NurseViewModel extends AndroidViewModel
{
    // calling repository tasks and
    // sending the results to the Activity
    private NurseRepository nurseRepository;
    //
    public NurseViewModel(@NonNull Application application)
    {
        super(application);
        nurseRepository = new NurseRepository(application);
    }
    //calls repository to insert a person
    public void insert(Nurse nurse) {
        nurseRepository.insert(nurse);
    }

    public Nurse getNurse(int nurseId, String password){
        Nurse nurse = nurseRepository.getNurse(nurseId, password);
        if (nurse == null){
            return null;
        }
        else{
            return nurse;
        }

    }

}
