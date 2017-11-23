package com.example.acer.merisaathi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Pregnancy_Tips extends AppCompatActivity {
    ListView lv1;
    String[] ptips={"Try fortified ready-to-eat or cooked breakfast cereals with fruit. Fortified cereals" +
            " have added nutrients, like calcium.",
            "If you are feeling sick, start with whole wheat toast. Eat more food later in the morning",
            "Choose a variety of vegetables and fruits, like carrots, cooked greens, bananas, and melon",
            "Take a prenatal vitamin with iron and folic acid every day." +
                    "Iron keeps your blood healthy. Folic acid helps prevent birth defects",
            " Limit caffeine and avoid alcohol",
            "Some foods like feta, Brie, goat cheese," +
                    " Uncooked or undercooked meats or fish (like sushi) may have bacteria that can hurt your baby. Don't eat"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy__tips);
        lv1 = (ListView) findViewById(R.id.pregnancy_tips_lv1);
        customview adapter = new customview(Pregnancy_Tips.this,ptips);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              //  Toast.makeText(Pregnancy_Tips.this, "You clicke"+ ptips[position],  Toast.LENGTH_SHORT).show();
            }
        });
    }
}
