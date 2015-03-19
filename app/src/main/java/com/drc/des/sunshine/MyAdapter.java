package com.drc.des.sunshine;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Weather> {

    Context context;
    int layoutResourceId;
    ArrayList<Weather> data = null;

    public MyAdapter(Context context, int layoutResourceId, ArrayList<Weather> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    static class ViewHolder
    {
        ImageView weatherImage;
        TextView dayOfWeek;
        TextView highTemp;
        TextView lowTemp;
        TextView clouds;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;

        if(view == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.weatherImage = (ImageView) view.findViewById(R.id.list_item_icon);
            holder.dayOfWeek = (TextView) view.findViewById(R.id.list_item_date_textview);
            holder.highTemp = (TextView) view.findViewById(R.id.list_item_high_textview);
            holder.lowTemp = (TextView) view.findViewById(R.id.list_item_low_textview);
            holder.clouds = (TextView) view.findViewById(R.id.list_item_forecast_textview);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        int image = data.get(position).getImage();
        String weekDay = data.get(position).getWeekDay();
        String tempHigh = data.get(position).getTempHigh();
        String tempLow = data.get(position).getTempLow();
        String condition = data.get(position).getCondition();

        holder.weatherImage.setImageResource(image);
        holder.dayOfWeek.setText(weekDay);
        holder.highTemp.setText(tempHigh);
        holder.lowTemp.setText(tempLow);
        holder.clouds.setText(condition);

        return view;
    }

}
