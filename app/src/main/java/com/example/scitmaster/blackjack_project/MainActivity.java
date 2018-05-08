package com.example.scitmaster.blackjack_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button starter;
    ImageView mainimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        starter=findViewById(R.id.startbtn);
        mainimage=findViewById(R.id.blackjack);
    }

    public void Start(View view){
        Intent intent=new Intent(this, Blackjack.class);
        startActivity(intent);
    }


}
