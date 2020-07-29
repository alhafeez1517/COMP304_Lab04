package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class EnterTestDataActivity extends AppCompatActivity {
    private SharedPreferences myPreference;
    SharedPreferences.Editor prefEditor;
    private MedicalTestViewModel medicalTestViewModel;
    EditText bpl, bpm, temp, ferritin, cholesterol;

    int patientId, nurseId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_test_data);
        medicalTestViewModel = ViewModelProviders.of(this).get(MedicalTestViewModel.class);
        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();

        bpl = (EditText) findViewById(R.id.txBPL);
        bpm = (EditText) findViewById(R.id.txBPM);
        temp = (EditText) findViewById(R.id.txTemp);
        ferritin = (EditText) findViewById(R.id.txFerritin);
        cholesterol = (EditText) findViewById(R.id.txCholesterol);

        patientId = myPreference.getInt("patientId", 0) - 100000;
        nurseId = myPreference.getInt("nurseId", 0);
    }

    public void onAddAttempt(View view) {
        MedicalTest medicalTest = new MedicalTest(
                patientId,
                nurseId,
                Float.parseFloat(bpl.getText().toString()),
                Float.parseFloat(bpm.getText().toString()),
                Float.parseFloat(temp.getText().toString()),
                Float.parseFloat(ferritin.getText().toString()),
                Float.parseFloat(cholesterol.getText().toString())
        );
        medicalTestViewModel.insert(medicalTest);
        Toast.makeText(EnterTestDataActivity.this, "Test added successfully!", Toast.LENGTH_SHORT).show();
        finish();
    }
}