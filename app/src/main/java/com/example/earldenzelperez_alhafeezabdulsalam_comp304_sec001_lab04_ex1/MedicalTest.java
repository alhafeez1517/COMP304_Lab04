package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MedicalTest
{
    @PrimaryKey
    private int testId;

    private int patientId,nurseId;

    float bpl,bpm,temperature;

    public MedicalTest()
    {

    }

    public MedicalTest(int testId, int patientId, int nurseId, float bpl, float bpm, float temperature)
    {
        this.testId = testId;
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.bpl = bpl;
        this.bpm = bpm;
        this.temperature = temperature;

    }

    public int getTestId() { return testId; }
    public void setTestId(int id) { this.testId=id; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int id) { this.patientId=id; }

    public int getNurseId() { return nurseId; }
    public void setNurseId(int id) { this.nurseId=id; }

    public float getBpm() { return bpm; }
    public void setBpm(float bpm) { this.bpm=bpm; }

    public float getBpl() { return bpl; }
    public void setBpl(float bpl) { this.bpl=bpl; }

    public float getTemperature() { return temperature; }
    public void setTemperature(float temperature) { this.temperature=temperature; }


}