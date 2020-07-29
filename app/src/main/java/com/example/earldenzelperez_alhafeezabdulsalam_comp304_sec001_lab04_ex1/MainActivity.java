package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity
{
    private SharedPreferences myPreference;
    SharedPreferences.Editor prefEditor;
    Button login, enterPatient, enterTest, viewTest, updatePatient, logout;
    TextView txIndicator;
    private NurseViewModel nurseViewModel;
    int loaded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();

        login = (Button) findViewById(R.id.btnLogIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Nurse nurse1, nurse2;
                nurse1 = new Nurse(1001, "Al Hafeez", "Abdul Salam", "Oncology", "password");
                nurse2 = new Nurse(1002, "Earl Denzel", "Perez", "Emergency", "password");
                nurseViewModel.insert(nurse1);
                nurseViewModel.insert(nurse2);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        enterPatient = (Button) findViewById(R.id.btnEnterPatient);
        enterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EnterPatientActivity.class));
            }
        });

        enterTest = (Button) findViewById(R.id.btnEnterTest);
        enterTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EnterTestDataActivity.class));
            }
        });

        viewTest = (Button) findViewById(R.id.btnViewTest);
        viewTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewTestInfoActivity.class));
            }
        });

        updatePatient = (Button) findViewById(R.id.btnUpdatePatient);
        updatePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UpdatePatientInfoActivity.class));
            }
        });

        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefEditor.putInt("nurseId", 0);
                prefEditor.commit();
                finish();
                startActivity(getIntent());
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (checkLoggedIn()){
            login.setVisibility(View.INVISIBLE);
            enterPatient.setVisibility(View.VISIBLE);
            enterTest.setVisibility(View.VISIBLE);
            viewTest.setVisibility(View.VISIBLE);
            updatePatient.setVisibility(View.VISIBLE);
            logout.setVisibility(View.VISIBLE);
        }
        else{
            login.setVisibility(View.VISIBLE);
            enterPatient.setVisibility(View.INVISIBLE);
            enterTest.setVisibility(View.INVISIBLE);
            viewTest.setVisibility(View.INVISIBLE);
            updatePatient.setVisibility(View.INVISIBLE);
            logout.setVisibility(View.INVISIBLE);
        }
    }

    private boolean checkLoggedIn(){
        int nurseId = myPreference.getInt("nurseId", 0);
        txIndicator = (TextView) findViewById(R.id.txtUserIndicator);
        if (  nurseId > 0){
            txIndicator.setText(myPreference.getString("nurseName", "UNKNOWN_USER"));
            return true;
        }
        else{
            txIndicator.setText(getResources().getString(R.string.login_required));
        }
        return false;
    }

}