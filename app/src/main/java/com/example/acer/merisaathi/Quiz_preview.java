package com.example.acer.merisaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Quiz_preview extends AppCompatActivity {
    TextView show_time;
        int count=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_preview);
        show_time=(TextView)findViewById(R.id.preview_time);
        final Thread t=new Thread(){
            @Override
            public void run(){
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        if (count<=0) {
                            throw new InterruptedException();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count--;
                                if(count==0)
                                {
                                    show_time.setText("Start");
                                }
                                else{
                                    show_time.setText(String.valueOf(count));
                                }


                            }
                        });
                    }
                   catch (InterruptedException e) {
                            interrupt();
                        Intent intent=new Intent(Quiz_preview.this,Online_Quiz.class);
                        startActivity(intent);
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(false);
    }
}
