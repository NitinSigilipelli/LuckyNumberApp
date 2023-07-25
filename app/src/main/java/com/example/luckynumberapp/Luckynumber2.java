package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Luckynumber2 extends AppCompatActivity {
    Button btn1;
    TextView txt1,welcome_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luckynumber2);
        welcome_txt = findViewById(R.id.lucky_number);
        btn1 = findViewById(R.id.Share_btn);
        txt1 = findViewById(R.id.lucky_number_txt);
        Intent i = new Intent();
        //username
        String userName = i.getStringExtra("name");
        //random number generated
        int random_Num = generateRandomNumber();
        txt1.setText(""+random_Num);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,random_Num);
            }
        });

    }
    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
    public void shareData(String username,int random_number) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,username+"got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"Lucky number is "+random_number);
        startActivity(Intent.createChooser(i,"choose a platform"));
    }

}