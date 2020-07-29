package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.util.Iterator;
import java.util.List;

public class ViewPatientInfoActivity extends AppCompatActivity {
    private SharedPreferences myPreference;
    SharedPreferences.Editor prefEditor;
    private PatientViewModel patientViewModel;
    private List<Patient> patientList;
    private RadioGroup rg;
    private RadioButton[] rb;
    private TextView notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_info);
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();
        notice = (TextView) findViewById(R.id.txtNotice);
    }

    @Override
    protected void onStart(){
        super.onStart();
        patientList = patientViewModel.getAllPatientsForNurse(myPreference.getInt("nurseId", 0));

        if(patientList.size() > 0){
            notice.setText(R.string.click_to_edit);
        }
        else{
            notice.setText(R.string.no_patients);
        }

        rb = new RadioButton[patientList.size()];
        rg = (RadioGroup) findViewById(R.id.rgPatients);
        rg.removeAllViews();

        Iterator<Patient> it = patientList.iterator();
        int i = 0;
        while(it.hasNext()){
            Patient patient = it.next();
            rb[i]  = new RadioButton(this);
            rb[i].setText(
                    " Patient #" + patient.getPatientId() + " " + patient.getFirstName() + " " + patient.getLastName() +
                            "\n Room: " + patient.getRoom() +
                            "\n Department: " + patient.getDepartment()
            );
            rb[i].setId(patient.getPatientId() + 100000);
            rg.addView(rb[i]);
            i++;
        }

    }

    public void onUpdatePatient(View view) {
        if (rg.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "You have to select a user!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, UpdatePatientInfoActivity.class);
            for(int i = 0; i<rb.length; i++){
                if (rb[i].isChecked()){
                    prefEditor.putInt("patientId", rb[i].getId());
                    prefEditor.commit();
                    startActivity(intent);
                }
            }
        }
    }

    public void onAddTests(View view) {
        if (rg.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "You have to select a user!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, EnterTestDataActivity.class);
            for(int i = 0; i<rb.length; i++){
                if (rb[i].isChecked()){
                    prefEditor.putInt("patientId", rb[i].getId());
                    prefEditor.commit();
                    startActivity(intent);
                }
            }
        }
    }

    public void onViewTests(View view) {
        if (rg.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this, "You have to select a user!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(this, ViewTestInfoActivity.class);
            for(int i = 0; i<rb.length; i++){
                if (rb[i].isChecked()){
                    prefEditor.putInt("patientId", rb[i].getId());
                    prefEditor.commit();
                    startActivity(intent);
                }
            }
        }
    }
}