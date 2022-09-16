package com.example.bt4_dichuyen2manhinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView txtView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addControls();

    }

    private void addControls() {
        txtView = findViewById(R.id.message_TextView);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bun");
        txtView.setText(bundle.getString("message"));
    }

    public void back(View view) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
