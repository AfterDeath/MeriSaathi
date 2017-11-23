package com.example.acer.merisaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score_show extends AppCompatActivity {
    TextView txtView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_show);

        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        txt=(TextView)findViewById(R.id.score_tv1);
        txtView = (TextView) findViewById(R.id.score_tv2);
        txtView.setText(message);
        if(message.equals("Oops!! time's off")){
            txtView.setTextSize(30);
            txt.setText("");
        }
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(false);
        Intent intent=new Intent(score_show.this,NavigationDrawer.class);
        startActivity(intent);
    }
}
