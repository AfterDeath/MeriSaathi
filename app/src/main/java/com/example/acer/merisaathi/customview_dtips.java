package com.example.acer.merisaathi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by TXR on 18/11/2017.
 */

public class customview_dtips extends BaseAdapter {
    private Context dContext;
    private final String[] dtips;

    public customview_dtips(Context dContext, String[] dtips) {
        this.dContext = dContext;
        this.dtips = dtips;
    }

    @Override
    public int getCount() {
        return dtips.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View list;
        LayoutInflater inflater = (LayoutInflater) dContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            list = new View(dContext);
            list = inflater.inflate(R.layout.activity_dtips, null);
            TextView textView = (TextView) list.findViewById(R.id.disease_text);
            //  ImageView imageview = (ImageView) list.findViewById(R.id.grid_image);
            textView.setText(dtips[position]);
            //imageview.setImageResource(imageId[position]);
        } else {
            list = (View) convertView;
        }

        return list;
    }
}