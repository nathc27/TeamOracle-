package com.example.teamoracle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextView password;
    private TextView username;
    private Button login;
    private Button register;
    private SharedPreferences preferences;
    private static final String PREFS_NAME = "PrefsFile";
    private TextView link_forgot_password ;
    private FirebaseAuth authentication;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseApp.initializeApp(LoginActivity.this);
        authentication = FirebaseAuth.getInstance();
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        password = findViewById(R.id.input_confirm_password);
        username = findViewById(R.id.input_name);
        login = findViewById(R.id.btn_signUp);
        register = findViewById(R.id.createAccountButton);
        link_forgot_password = findViewById(R.id.link_forgot_password);

        link_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);

            }
        });
    }

    public void btn_login_Click (View view){
        final ProgressDialog progressDialog= ProgressDialog.show(LoginActivity.this, "Please wait", "Processing...", true);
        (authentication.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(LoginActivity.this, DashboardActivity.class);
                            login.putExtra("Email", authentication.getCurrentUser().getEmail());
                            login.putExtra("Name", authentication.getCurrentUser().getDisplayName());
                            startActivity(login);
                        } else {
                            Log.e("Wrong email or password", task.getException().toString());
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void btn_signUp_Click (View v){
        Intent signUp = new Intent (LoginActivity.this, SignUpActivity.class);
        startActivity(signUp);
    }

}