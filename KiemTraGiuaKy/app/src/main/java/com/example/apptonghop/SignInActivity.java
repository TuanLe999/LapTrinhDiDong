package com.example.apptonghop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        AppCompatButton signIn_btn =(AppCompatButton) findViewById(R.id.signin_button);
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, com.example.apptonghop.HomeActivity.class);
                startActivity(intent);
            }
        });

        AppCompatButton signUp_btn =(AppCompatButton) findViewById(R.id.signUp_btn);
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, com.example.apptonghop.SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
