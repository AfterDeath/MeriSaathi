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

public class customView_ptips extends BaseAdapter {
    private Context pContext;
    private final String[] ptips;

    public customView_ptips(Context mContext, String[] ptips) {
        this.pContext = pContext;
        this.ptips = ptips;
    }

    @Override
    public int getCount() {
        return ptips.length;
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
        LayoutInflater inflater = (LayoutInflater) pContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            list = new View(pContext);
            list = inflater.inflate(R.layout.mtips, null);
            TextView textView = (TextView) list.findViewById(R.id.grid_text);
            //  ImageView imageview = (ImageView) list.findViewById(R.id.grid_image);
            textView.setText(ptips[position]);
            //imageview.setImageResource(imageId[position]);
        } else {
            list = (View) convertView;
        }

        return list;
    }
}
