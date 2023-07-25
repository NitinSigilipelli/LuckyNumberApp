package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.sign_btn);
        editText = findViewById(R.id.editText);
        txt = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = editText.getText().toString();
                Intent i = new Intent(getApplicationContext(),Luckynumber2.class);
                i.putExtra("name",user_name);
                startActivity(i);
            }
        });
    }
}