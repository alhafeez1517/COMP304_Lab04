package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Patient.class, MedicalTest.class, Nurse.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "HospitalData";
    public abstract PatientDao patientDao();
    public abstract NurseDao nurseDao();
    //

    //
    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
