package com.example.acer.merisaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Button b1=(Button)findViewById(R.id.tips_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Menstrual_Tips.class);
                startActivity(intent);
            }
        });
        Button  b2=(Button)findViewById(R.id.tips_b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Pregnancy_Tips.class);
                startActivity(intent);
            }
        });
        Button b3=(Button)findViewById(R.id.tips_b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Tips.this,Women_Rights.class);
                startActivity(intent);
            }
        });
        Button b4=(Button)findViewById(R.id.tips_b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Tips.this,disease.class);
                startActivity(intent);
            }
        });


        }
    }

