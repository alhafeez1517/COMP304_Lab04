package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class PatientViewModel extends AndroidViewModel
{
    // calling repository tasks and
    // sending the results to the Activity
    private PatientRepository patientRepository;
    private List<Patient> allPatients;
    //
    public PatientViewModel(@NonNull Application application)
    {
        super(application);
        patientRepository = new PatientRepository(application);
    }
    //calls repository to insert a person
    public void insert(Patient person) {
        patientRepository.insert(person);
    }

    public int checkPatientExists(int id){ return patientRepository.checkPatientExists(id);}

    public List<Patient> getAllPatientsForNurse(int id){ return patientRepository.getAllPatientsForNurse(id);}

    public Patient getPatient(int id){ return patientRepository.getPatient(id);}
}
