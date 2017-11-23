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

public class customview_wtips extends BaseAdapter {
    private Context wContext;
    private final String[] wtips;

    public customview_wtips(Context wContext, String[] wtips) {
        this.wContext = wContext;
        this.wtips = wtips;
    }

    @Override
    public int getCount() {
        return wtips.length;

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
        LayoutInflater inflater = (LayoutInflater) wContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            list = new View(wContext);
            list = inflater.inflate(R.layout.mtips, null);
            TextView textView = (TextView) list.findViewById(R.id.wtips_text);
            //  ImageView imageview = (ImageView) list.findViewById(R.id.grid_image);
            textView.setText(wtips[position]);
            //imageview.setImageResource(imageId[position]);
        } else {
            list = (View) convertView;
        }

        return list;
    }
}
