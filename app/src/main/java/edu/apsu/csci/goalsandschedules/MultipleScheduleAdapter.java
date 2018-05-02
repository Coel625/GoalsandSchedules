package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MultipleScheduleAdapter extends ArrayAdapter<Schedule> {
    private final Context context;
    private final List<Schedule> data;
    private final int layoutResourceId;

    public MultipleScheduleAdapter(Context context, int layoutResourceId, List<Schedule> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.data = data;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MultipleScheduleAdapter.ViewHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.textView1 = (TextView)row.findViewById(R.id.scheduleEntryTimes);
            holder.textView2 = (TextView)row.findViewById(R.id.scheduleEntryDate);
            holder.textView3 = (TextView)row.findViewById(R.id.scheduleEntryShort);
            holder.textView4 = (TextView)row.findViewById(R.id.scheduleEntryDesc);

            row.setTag(holder);
        }
        else
        {
            holder = (MultipleScheduleAdapter.ViewHolder)row.getTag();
        }

        Schedule schedule = data.get(position);
        String setScheduleTime = schedule.getTime();
        String setScheduleDate = schedule.getDate();
        String setScheduleShort = schedule.getShortterm_id();

        holder.textView1.setText(setScheduleTime);
        holder.textView2.setText(setScheduleDate);
        holder.textView3.setText(setScheduleShort);
        holder.textView4.setText(schedule.getDescription());

        return row;
    }

    static class ViewHolder
    {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
    }
}