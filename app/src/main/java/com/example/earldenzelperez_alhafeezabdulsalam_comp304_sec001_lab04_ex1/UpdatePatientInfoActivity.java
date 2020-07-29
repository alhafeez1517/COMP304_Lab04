package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class UpdatePatientInfoActivity extends AppCompatActivity {
    private SharedPreferences myPreference;
    SharedPreferences.Editor prefEditor;
    private PatientViewModel patientViewModel;
    private Patient patient;
    EditText editFn, editLn, editDepartment, editRoom;
    int patientId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_patient_info);
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();

        editFn = (EditText) findViewById(R.id.txPtFirstNameEdit);
        editLn = (EditText) findViewById(R.id.txPtLastNameEdit);
        editDepartment = (EditText) findViewById(R.id.txDepartmentEdit);
        editRoom = (EditText) findViewById(R.id.txRoomEdit);

        patientId = myPreference.getInt("patientId", 0) - 100000;
        patient = patientViewModel.getPatient(patientId);

        editFn.setText(patient.getFirstName());
        editLn.setText(patient.getLastName());
        editDepartment.setText(patient.getDepartment());
        editRoom.setText(""+patient.getRoom());
    }


    public void onUpdateAttempt(View view) {
        String validationMessage = "";
        if (editFn.getText().toString().isEmpty()
                || editLn.getText().toString().isEmpty()
                || editDepartment.getText().toString().isEmpty()
                || editRoom.getText().toString().isEmpty())
        {
            validationMessage += "You have to fill up all fields!";
        }
        if (validationMessage.isEmpty()){
            Patient patient = new Patient(
                    patientId,
                    myPreference.getInt("nurseId", 0),
                    Integer.parseInt(editRoom.getText().toString()),
                    editFn.getText().toString(),
                    editLn.getText().toString(),
                    editDepartment.getText().toString()
            );
            patientViewModel.insert(patient);
            Toast.makeText(UpdatePatientInfoActivity.this, "Patient # " + patientId + " updated successfully!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(UpdatePatientInfoActivity.this, validationMessage, Toast.LENGTH_SHORT).show();
        }
    }

}