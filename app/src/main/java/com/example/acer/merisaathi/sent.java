package com.example.acer.merisaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class sent extends AppCompatActivity {
    int count = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent);



      //  Toast.makeText(sent.this,"sms sent",Toast.LENGTH_SHORT).show();
        final Thread t = new Thread () {
            @Override
            public void run(){
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        if (count >=0.5 ){
                            throw new InterruptedException();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;

                            }
                        });
                    } catch (InterruptedException e) {
                        interrupt();
                        Intent intent = new Intent(sent.this, NavigationDrawer.class);
                        startActivity(intent);
                        e.printStackTrace();
                    }
                }

            }
        };
        t.start();

    }
}
