package com.example.acer.merisaathi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Women_Rights extends AppCompatActivity {
    ListView lv1;
    String[] wtips={
            "Every woman has the right to participate in the same sports and physical education",
            "Every woman has the equal inalienable right to work.",
            "Every woman has the equal inalienable right to work.",
            "Every woman has equal rights to family benefits.",
            "Every woman has the equal right to health and health care services especially with regard to family planning.",
            "Every woman has the equal right to be promoted in employment.",
            "•\tEvery woman has the right to participate in the formulation and implementation of government policy."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women__rights);
        lv1 = (ListView) findViewById(R.id.women_rights_lv1);
        customview adapter = new customview(Women_Rights.this,wtips);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
             //   Toast.makeText(Women_Rights.this, "You clicke"+ wtips[position],  Toast.LENGTH_SHORT).show();
            }
        });
    }
}
