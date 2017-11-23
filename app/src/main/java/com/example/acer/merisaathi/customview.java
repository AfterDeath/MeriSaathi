package com.example.acer.merisaathi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by acer on 11/12/2017.
 */

public class customview extends BaseAdapter{

    private Context mContext;
    private final String[] mtips;
   // private final int[] imageId;

    public customview(Context c, String[] mtips){

        mContext = c;
       // this.imageId = imageId;
        this.mtips = mtips;

    }




    @Override
    public int getCount() {
        return mtips.length;
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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            list = new View(mContext);
            list = inflater.inflate(R.layout.mtips, null);
            TextView textView = (TextView) list.findViewById(R.id.grid_text);
          //  ImageView imageview = (ImageView) list.findViewById(R.id.grid_image);
            textView.setText(mtips[position]);
            //imageview.setImageResource(imageId[position]);
        } else {
            list = (View) convertView;
        }

        return list;

    }
}
