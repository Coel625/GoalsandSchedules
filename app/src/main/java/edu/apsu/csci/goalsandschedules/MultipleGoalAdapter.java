package edu.apsu.csci.goalsandschedules;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MultipleGoalAdapter extends ArrayAdapter<LongTermGoal> {
    private final Context context;
    private final List<LongTermGoal> data;
    private final int layoutResourceId;

    public MultipleGoalAdapter(Context context, int layoutResourceId, List<LongTermGoal> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.data = data;
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.textView1 = (TextView)row.findViewById(R.id.goalListNameData);
            holder.textView2 = (TextView)row.findViewById(R.id.goalListDescData);
            holder.textView3 = (ProgressBar)row.findViewById(R.id.progressBar);
            holder.textView4 = (TextView)row.findViewById(R.id.goalListShortData);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)row.getTag();
        }

        LongTermGoal longTermGoal = data.get(position);

        holder.textView1.setText(longTermGoal.getTitle());
        holder.textView2.setText(longTermGoal.getDescription());
        holder.textView3.setProgress(longTermGoal.getProgress());
        holder.textView4.setText(longTermGoal.getSubgoal());

        return row;
    }

    static class ViewHolder
    {
        TextView textView1;
        TextView textView2;
        ProgressBar textView3;
        TextView textView4;
    }
}