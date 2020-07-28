package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.app.Person;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NurseDao
{
    @Insert
    void insert(Nurse nurse);

    @Query("select * from Nurse order by nurseId")
    LiveData<List<Nurse>> getAllNurses();
}