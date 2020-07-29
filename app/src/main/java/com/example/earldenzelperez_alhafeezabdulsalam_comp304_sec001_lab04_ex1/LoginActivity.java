package com.example.earldenzelperez_alhafeezabdulsalam_comp304_sec001_lab04_ex1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences myPreference;
    private NurseViewModel nurseViewModel;
    SharedPreferences.Editor prefEditor;
    Button trueLogin;
    private EditText txtNurseId;
    private EditText txtPassword;
    private TextView txtCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        trueLogin = (Button) findViewById(R.id.btnTrueLogin);
        trueLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNurseId = (EditText) findViewById(R.id.txtNurseId);
                txtPassword = (EditText) findViewById(R.id.txtPassword);

                Nurse nurse = nurseViewModel.getNurse(Integer.parseInt(txtNurseId.getText().toString()), txtPassword.getText().toString());
                if (nurse != null){
                    myPreference = getSharedPreferences("info", MODE_PRIVATE);
                    prefEditor = myPreference.edit();
                    prefEditor.putInt("nurseId", nurse.getNurseId());
                    prefEditor.putString("nurseName", "Currently logged in as: " + nurse.getFirstName() + " " + nurse.getLastName() + " of " + nurse.getDepartment());
                    prefEditor.commit();
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid nurse id or password", Toast.LENGTH_SHORT).show();

                }
            }
        });






    }
}