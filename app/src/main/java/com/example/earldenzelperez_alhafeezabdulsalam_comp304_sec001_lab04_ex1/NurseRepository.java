package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Person;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class NurseRepository
{

    private final NurseDao nurseDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Nurse>> nurseList;
    //
    public NurseRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        nurseDao = db.nurseDao();
        //call interface method
        nurseList = nurseDao.getAllNurses();
    }
    // returns query results as LiveData object

    LiveData<List<Nurse>> getAllNurses()
    {
        return nurseList;
    }
    //inserts a patient asynchronously

    public void insert(Nurse nurse)
    {
        insertAsync(nurse);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult()
    {
        return insertResult;
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
