 package com.example.tuan_bt2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {
     public Button button_first;
     public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_first= findViewById(R.id.button_first);
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();
            }
        });
    }
     public void openNewActivity(){
         Intent intent = new Intent(this, InfoScreen.class);
         startActivity(intent);
     }
}