package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;


    private final String UserName ="Admin";
    private final String PassWord = "DSC@Sastra";
    boolean isValid = false;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eName = findViewById(R.id.username);
        ePassword = findViewById(R.id.password);
        eLogin = findViewById(R.id.login);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty()|| inputPassword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    isValid = validate(inputName,inputPassword);
                    if(!isValid)
                    {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    } else{
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }


                }

            }
        });

    }
    private boolean validate(String name,String password)
    {
        if (name.equals(UserName)&& password.equals(PassWord)){
            return true;
        }
        return false;
    }
}
