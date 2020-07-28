package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Person;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PatientRepository
{

    private final PatientDao patientDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Patient>> patientsList;
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

    LiveData<List<Patient>> getAllPatients()
    {
        return patientsList;
    }
    //inserts a patient asynchronously

    public void insert(Patient patient)
    {
        insertAsync(patient);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult()
    {
        return insertResult;
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
                    insertResult.postValue(1);
                }
                catch (Exception e)
                {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
