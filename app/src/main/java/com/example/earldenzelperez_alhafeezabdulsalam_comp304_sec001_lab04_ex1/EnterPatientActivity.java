package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class EnterPatientActivity extends AppCompatActivity {

    private SharedPreferences myPreference;
    SharedPreferences.Editor prefEditor;
    private PatientViewModel patientViewModel;

    EditText txtPatientId, txtPtFn, txtPtLn, txtRoom, txtDept;
    Button btnAddPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_patient);
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();

        txtPatientId = (EditText) findViewById(R.id.txPatientId);
        txtPtFn = (EditText) findViewById(R.id.txPtFirstName);
        txtPtLn = (EditText) findViewById(R.id.txPtLastName);
        txtRoom = (EditText) findViewById(R.id.txRoom);
        txtDept = (EditText) findViewById(R.id.txDepartment);
        btnAddPatient = (Button) findViewById(R.id.btnAddPt);

        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String validationMessage = "";
                if (txtPatientId.getText().toString().isEmpty()
                        || txtPtFn.getText().toString().isEmpty()
                        || txtPtLn.getText().toString().isEmpty()
                        || txtRoom.getText().toString().isEmpty()
                        || txtDept.getText().toString().isEmpty()
                ){
                    validationMessage += "You have to fill up all fields!";
                }
                else{
                    if (patientViewModel.checkPatientExists(Integer.parseInt(txtPatientId.getText().toString())) > 0){
                        validationMessage += "Patient ID #" + txtPatientId.getText() +  " is already taken. Please choose a different Id";
                    }
                }

                if (validationMessage.isEmpty()){
                    Patient patient = new Patient(
                            Integer.parseInt(txtPatientId.getText().toString()),
                            myPreference.getInt("nurseId", 0),
                            Integer.parseInt(txtRoom.getText().toString()),
                            txtPtFn.getText().toString(),
                            txtPtLn.getText().toString(),
                            txtDept.getText().toString()
                    );
                    patientViewModel.insert(patient);
                    Toast.makeText(EnterPatientActivity.this, "Patient # " + txtPatientId.getText().toString() + " added successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(EnterPatientActivity.this, validationMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}