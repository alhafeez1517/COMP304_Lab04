package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;

@Entity
public class Nurse
{

    @PrimaryKey
    private int nurseId;
    private String firstName,lastName,department,password;

    public Nurse()
    {

    }

    public Nurse(int nurseId,String firstName, String lastName,String department,String password)
    {
        this.nurseId = nurseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.password = password;

    }

    public int getNurseId() { return nurseId; }
    public void setNurseId(int id) { this.nurseId=id;}

    public String getFirstName() { return firstName; }
    public void setFirstName(String fName){this.firstName=fName;}

    public String getLastName() { return lastName; }
    public void setLastName(String lName){this.lastName = lName;}

    public String getDepartment() { return department; }
    public void setDepartment(String department){this.department = department;}

    public String getPassword() { return password; }
    public void setPassword(String password){this.password = password;}





}