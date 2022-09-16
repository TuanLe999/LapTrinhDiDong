package com.example.bt4_dichuyen2manhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void send_message(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle bundle = new Bundle();
        EditText text = (EditText) findViewById(R.id.label);
        String value = text.getText().toString();
        bundle.putString("message", value);
        intent.putExtra("bun",bundle);
        startActivity(intent);
    }
}