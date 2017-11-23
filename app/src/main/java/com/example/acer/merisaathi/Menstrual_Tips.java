package com.example.acer.merisaathi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Menstrual_Tips extends AppCompatActivity {
    ListView lv1;
    String[] mtips={
            " Frequent switching between brands can make you uncomfortable since brands are as unique as you, they suit everyone differently.",
            " There are a few instances where your sanitary napkin or tampon might not be completely used – usually on days when you have a lesser flow – but you must change at regular intervals." +
                    "The standard time to change a sanitary pad is once every six hours, while for a tampon is once every two hours. ",
            " It is important to wash your vagina and labia (the projecting part of female genitals) well before you change into a new pad." +
                    " If you cannot wash yourself before you change make sure to wipe off the areas using toilet paper or tissue.",
            " Washing it with soap can kill the good bacteria making way for infections. " +
                    "You can use soap on the external parts but do not use it inside your vagina or vulva.",
            " To avoid urinary tract infections, always wash or clean the area in a motion that is from the vagina to the anus.",
            " A pad rash is something that you might experience during a period of heavy flow." +
                    " It usually occurs when the pad has been wet for a long time and rubs along the thighs causing it to chaff.",
            " Some women who have heavy flow during their periods tend to use either (i) two sanitary pads, (ii) a tampon and sanitary pad (iii) a sanitary pad along with a piece of cloth." +
                    " This might seem like a good idea, but it actually is not, changing regularly is a better option.",
            " If you are facing issues relating to periods or hygiene," +
                    " share with your gang. See how others are coping up with those red days of their life.",
            "Always carry some snacks and a water bottle in case you feel" +
                    " weak will always keep you prepared and make you feel confident at the time of your period.",
            "Use heat, such as hot water bottles, heating pads, " +
                    "or hot baths, to relax tense muscles and relieve cramping. Be careful not to burn yourself.",
            "Drink herbal teas, such as chamomile, mint, raspberry, " +
                    "and blackberry, which may help soothe tense muscles and anxious moods.",
            "Regular workouts decrease the severity of cramps."
    };
   int[] imageId= {
           R.drawable.orange,
           R.drawable.cat
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menstrual__tips);
        lv1 = (ListView) findViewById(R.id.menstrual_Tips_lv1);
        customview adapter = new customview(Menstrual_Tips.this,mtips);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              //  Toast.makeText(Menstrual_Tips.this, "You clicke"+ mtips[position],  Toast.LENGTH_SHORT).show();
            }
        });



    }
}
