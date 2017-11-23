package com.example.acer.merisaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button b1=(Button)findViewById(R.id.main_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });*/

        final Thread t=new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        if (count>=1) {
                            throw new InterruptedException();
                        }

                       runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;



                            }
                        });
                    }
                    catch (InterruptedException e) {
                        interrupt();
                        Intent intent=new Intent(MainActivity.this,login.class);
                        startActivity(intent);
                     e.printStackTrace();
                }
           }
       }
    };

        t.start();
    }

    }
