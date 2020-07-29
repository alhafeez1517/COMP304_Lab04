package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Context;

import java.util.List;

public class PatientRepository
{

    private final PatientDao patientDao;
    private List<Patient> patientsList;
    //
    public PatientRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        patientDao = db.patientDao();
        //call interface method
        patientsList = patientDao.getAllPatients();
    }
    // returns query results as LiveData object

    List<Patient> getAllPatients()
    {
        return patientsList;
    }
    //inserts a patient asynchronously

    public void insert(Patient patient)
    {
        insertAsync(patient);
    }

    private void insertAsync(final Patient patient)
    {

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    patientDao.insert(patient);
                }
                catch (Exception e)
                {
                }
            }
        }).start();
    }

    public int checkPatientExists(int id){ return patientDao.checkPatientExists(id);}

    public List<Patient> getAllPatientsForNurse(int id){ return patientDao.getAllPatientsForNurse(id);}

    public Patient getPatient(int id){ return patientDao.getPatient(id);}
}
