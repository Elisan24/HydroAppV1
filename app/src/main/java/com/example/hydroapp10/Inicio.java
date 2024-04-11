package com.example.hydroapp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;


public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        getSupportActionBar().hide();

        Thread thread = new Thread() {
            @Override
            public void run(){
                try {
                    SystemClock.sleep(3000);
                    startActivity(new Intent(Inicio.this, Login.class));
                    finish();
                }catch (Exception e){

                }
            }
        };thread.start();
    }
}