package com.example.acer.merisaathi;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.Format;

public class Calendar extends AppCompatActivity implements View.OnClickListener {

    private Cursor mCursor = null;
    private static final String[] COLS = new String[]
            {CalendarContract.Events.TITLE, CalendarContract.Events.DTSTART};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mCursor = getContentResolver().query(


                CalendarContract.Events.CONTENT_URI, COLS, null, null, null);
        mCursor.moveToFirst();


        Button b = (Button)findViewById(R.id.next);


        b.setOnClickListener(this);
        b = (Button)findViewById(R.id.previous);


        b.setOnClickListener(this);
        onClick(findViewById(R.id.previous));
    }

    public void onClick(View v) {
        TextView tv = (TextView)findViewById(R.id.data);


        String title = "N/A";


        Long start = 0L;


        switch(v.getId()) {
            case R.id.next:
                if(!mCursor.isLast()) mCursor.moveToNext();
                break;
            case R.id.previous:
                if(!mCursor.isFirst()) mCursor.moveToPrevious();
                break;
        }


        Format df = DateFormat.getDateFormat(this);
        Format tf = DateFormat.getTimeFormat(this);
        try {
            title = mCursor.getString(0);


            start = mCursor.getLong(1);


        } catch (Exception e) {
//ignore


        }


        tv.setText(title+" on "+df.format(start)+" at "+tf.format(start));


    }
}
