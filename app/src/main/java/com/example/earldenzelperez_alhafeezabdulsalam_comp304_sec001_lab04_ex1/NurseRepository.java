package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Context;

public class NurseRepository
{

    private final NurseDao nurseDao;

    //
    public NurseRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        nurseDao = db.nurseDao();
    }

    public void insert(Nurse nurse)
    {
        insertAsync(nurse);
    }

    private void insertAsync(final Nurse nurse)
    {

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    nurseDao.insert(nurse);
                }
                catch (Exception e)
                {
                }
            }
        }).start();
    }

    public Nurse getNurse(int id, String password){
        return nurseDao.getNurse(id, password);
    }
}
