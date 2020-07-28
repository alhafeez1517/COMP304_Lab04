package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


import android.os.Bundle;
@Entity
public class Patient
{
    @PrimaryKey
    private int patientId;
    private int nurseId;
    private int room;

   private String firstName,lastName,department;

    public Patient()
    {

    }

    public Patient(int patientId,int nurseId,int room, String firstName, String lastName,String department)
    {
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.room = room;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;

    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int id) {
        this.patientId = id;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String fName){this.firstName=fName;}

    public String getLastName() { return lastName; }
    public void setLastName(String lName){this.lastName = lName;}

    public String getDepartment() { return department; }
    public void setDepartment(String department){this.department = department;}

    public int getRoom() { return room; }
    public void setRoom(int room){ this.room = room;}

    public int getNurseId() { return nurseId; }
    public void setNurseId(int id) { this.nurseId=id;}

}