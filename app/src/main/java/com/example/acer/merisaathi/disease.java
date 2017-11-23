package com.example.acer.merisaathi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class disease extends AppCompatActivity {
    ListView lv1;
    String[] dtips={"One of the first things to do when you have a urinary tract infection is drink plenty of water. ",
            " Women should avoid heavy lifting, such as in a bodybuilding program or some" +
                    " occupations, to prevent uterine prolapse. ",
            "Combination hormone therapy for more than three to five years increases the risk of breast cancer. ",
            " Fatty tissue in women who are overweight produces additional estrogen," +
                    " a sex hormone that can increase the risk of uterine cancer.",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        lv1 = (ListView) findViewById(R.id.disease_lv1);
        customview adapter = new customview(disease.this,dtips);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(disease.this, "You clicke"+ dtips[position],  Toast.LENGTH_SHORT).show();
            }
        });




    }
}
