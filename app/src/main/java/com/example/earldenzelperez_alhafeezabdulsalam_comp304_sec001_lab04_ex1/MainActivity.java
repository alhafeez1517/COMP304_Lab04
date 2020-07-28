package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity
{
    private NurseViewModel nurseViewModel;
    //preference data variable
    private SharedPreferences myPreference;
    //variable to modify preference data
    SharedPreferences.Editor prefEditor;
    Nurse nurse1, nurse2;
    Button login, enterPatient, enterTest, viewTest, updatePatient, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAllNurses();

        myPreference = getSharedPreferences("info", MODE_PRIVATE);
        prefEditor = myPreference.edit();

        login = (Button) findViewById(R.id.btnLogIn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        enterPatient = (Button) findViewById(R.id.btnEnterPatient);
        enterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        enterTest = (Button) findViewById(R.id.btnEnterTest);
        enterTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        viewTest = (Button) findViewById(R.id.btnViewTest);
        viewTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        updatePatient = (Button) findViewById(R.id.btnUpdatePatient);
        updatePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


    //prepopulates app with 2 nurses
    private void addAllNurses(){
        nurse1 = new Nurse();
        nurse1.setFirstName("Al Hafeez");
        nurse1.setLastName("Abdul Salam");
        nurse1.setNurseId(1001);
        nurse1.setDepartment("Oncology");
        nurse1.setPassword("password");

        nurse2 = new Nurse();
        nurse2.setFirstName("Earl Denzel");
        nurse2.setLastName("Perez");
        nurse2.setNurseId(1002);
        nurse2.setDepartment("Emergency");
        nurse2.setPassword("password");

        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);
        nurseViewModel.insert(nurse1);
        nurseViewModel.insert(nurse2);


    }

    private boolean checkLoggedIn(){
        if (myPreference.getInt("nurseId", 0) > 0){
            return true;
        }
        return false;
    }

}