package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Context;

import java.util.List;

public class MedicalTestRepository
{

    private final MedicalTestDao medicalTestDao;

    //
    public MedicalTestRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        medicalTestDao = db.medicalTestDao();
    }

    public void insert(MedicalTest medicalTest)
    {
        insertAsync(medicalTest);
    }

    private void insertAsync(final MedicalTest medicalTest)
    {

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    medicalTestDao.insert(medicalTest);
                }
                catch (Exception e)
                {
                }
            }
        }).start();
    }

    public List<MedicalTest> getAllTestsForPatient(int id){ return medicalTestDao.getAllTestsForPatient(id);}
}