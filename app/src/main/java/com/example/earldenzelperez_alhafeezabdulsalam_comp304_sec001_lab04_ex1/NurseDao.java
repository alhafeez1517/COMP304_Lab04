package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NurseDao
{
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Nurse nurse);

    @Query("select * from Nurse")
    List<Nurse> getAllNurses();

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Nurse where nurseId = :id and password = :password LIMIT 1")
    Nurse getNurse(int id, String password);
}