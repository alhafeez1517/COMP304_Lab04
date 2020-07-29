package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class ViewTestInfoActivity extends AppCompatActivity {
    private SharedPreferences myPreference;
    SharedPreferences.Editor prefEditor;
    private MedicalTestViewModel medicalTestViewModel;
    private List<MedicalTest> medicalTestList;
    private TextView patientNotice;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_info);
        medicalTestViewModel = ViewModelProviders.of(this).get(MedicalTestViewModel.class);
        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();
        patientNotice = (TextView) findViewById(R.id.txtPatientList);
        layout = (LinearLayout) findViewById(R.id.layoutTests);
    }

    @Override
    protected void onStart() {
        super.onStart();
        medicalTestList = medicalTestViewModel.getAllTestsForPatient(myPreference.getInt("patientId", 0) - 100000);

        if (medicalTestList.size() > 0) {
            patientNotice.setText(R.string.tests_present);
        } else {
            patientNotice.setText(R.string.no_tests_present);
        }

        for (int i = 0; i < medicalTestList.size(); i++) {
            MedicalTest test = medicalTestList.get(i);
            TextView testInfo = new TextView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(15,0,0, 15);
            testInfo.setLayoutParams(params);
            testInfo.setText("Test #" + test.getTestId() +
                    "\nBPL: " + test.getBpl() +
                    "\nBPM: " + test.getBpm() +
                    "\nTemperature: " + test.getTemperature() +
                    "\nFerritin: " + test.getFerritin() +
                    "\nCholesterol: " + test.getCholesterol()
            );

            layout.addView(testInfo);
        }
    }
}