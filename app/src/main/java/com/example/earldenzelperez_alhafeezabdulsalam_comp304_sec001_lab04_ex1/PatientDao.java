package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Person;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PatientDao
{
 @Insert
 void insert(Patient patient);

    @Query("select * from Patient order by firstName")

    LiveData<List<Patient>> getAllPatients();
}
