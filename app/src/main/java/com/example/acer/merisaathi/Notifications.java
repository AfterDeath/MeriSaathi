package com.example.acer.merisaathi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Notifications extends AppCompatActivity {
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        tv1=(TextView)findViewById(R.id.notifications_tv1);
        tv1.setText("Sanjeeb Pandey also replied in Discussion forum. \"My friend who iscurrently studying BBS...\"");
    }
}
