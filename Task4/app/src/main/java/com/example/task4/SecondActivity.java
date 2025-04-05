package com.example.task4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayText = findViewById(R.id.displayText);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String phone = bundle.getString("phone");
            String age = bundle.getString("age");

            displayText.setText("Name: " + name + "\nPhone: " + phone + "\nAge: " + age);
        }
    }
}
