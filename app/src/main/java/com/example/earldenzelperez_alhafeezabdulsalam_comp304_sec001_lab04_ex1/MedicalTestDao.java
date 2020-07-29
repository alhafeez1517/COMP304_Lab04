package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicalTestDao
{
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(MedicalTest medicalTest);

    @Query("select * from MedicalTest where patientId = :patientId")
    List<MedicalTest> getAllTestsForPatient(int patientId);
}