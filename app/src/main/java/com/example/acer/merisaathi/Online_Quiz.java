package com.example.acer.merisaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Online_Quiz extends AppCompatActivity {
    Button button1;
    String TO, SUBJECT, MESSAGE ;
    Intent intent ;
    int count=50;
    int score=0;
    RadioButton option1_3;
    RadioButton option2_2;
    RadioButton option3_2;
    RadioButton option4_4;
    RadioButton option5_3;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online__quiz);

        button1 = (Button)findViewById(R.id.button1);
        option1_3=(RadioButton)findViewById(R.id.option1_3);
        option2_2=(RadioButton)findViewById(R.id.option2_2);
        option3_2=(RadioButton)findViewById(R.id.option3_2);
        option4_4=(RadioButton)findViewById(R.id.option4_4);
        option5_3=(RadioButton)findViewById(R.id.option5_3);
        textView = (TextView) findViewById(R.id.trytext);
        final Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        if (count <= 0) {
                            throw new InterruptedException();

                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count--;
                                textView.setText(String.valueOf(count));
                                button1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(option1_3.isChecked()){
                                            score++;
                                        }if(option2_2.isChecked()){
                                            score++;
                                        }
                                        if(option3_2.isChecked()){
                                            score++;
                                        }
                                        if(option4_4.isChecked()){
                                            score++;
                                        }
                                        if(option5_3.isChecked()){
                                            score++;
                                        }



                                        String message=" "+score;
                                        intent=new Intent(Online_Quiz.this,score_show.class);
                                        intent.putExtra("message", message);
                                        startActivity(intent);

//                                        GetData(score);
//
//                                        intent = new Intent(Intent.ACTION_SEND);
//
//                                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{TO});
//                                        intent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
//                                        intent.putExtra(Intent.EXTRA_TEXT, MESSAGE);
//
//                                        intent.setType("message/rfc822");
//
//                                        startActivity(Intent.createChooser(intent, "Select Email Sending App :"));

                                    }
                                });



                            }

                        });
                    } catch (InterruptedException e) {
                        interrupt();
                        String message="Oops!! time's off";
                        intent=new Intent(Online_Quiz.this,score_show.class);
                        intent.putExtra("message", message);
                        startActivity(intent);

                        e.printStackTrace();
                    }
                    //public void cancel() { interrupt(); }
                }

            }
        };

        t.start();





    }
//    public void GetData(int score){
//
//        TO = "devkota.alina@gmail.com";
//        SUBJECT = "merisaathi online quiz";
//       // String str=toString(score);
//        MESSAGE = " "+score+" ";
//
//    }
    @Override
    public void onBackPressed(){
    moveTaskToBack(false);
    }
}
