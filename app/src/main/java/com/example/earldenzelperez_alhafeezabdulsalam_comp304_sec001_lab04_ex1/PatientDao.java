package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PatientDao
{
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Patient patient);

    @Query("select * from Patient where nurseId = :nurseId")
    List<Patient> getAllPatientsForNurse(int nurseId);

    @Query("select * from Patient where patientId = :patientId LIMIT 1")
    Patient getPatient(int patientId);


    @Query("select count(patientId) from Patient where patientId = :patientId")
    int checkPatientExists(int patientId);
}
