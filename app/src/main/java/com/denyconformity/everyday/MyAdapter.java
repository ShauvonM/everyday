package com.denyconformity.everyday;

import android.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shauvon McGill on 1/21/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private ArrayList<TaskData> mTaskData;
    private String[] colors;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<TaskData> datas) {
        mTaskData = datas;
        colors = new String[]{"#fff9c4","#b3e5fc","#e1bee7","#ffcdd2","#c8e6c9"};
    }

    // create new views (invoked by the layout manager)
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.task_view, parent, false);

        TaskViewHolder vh = new TaskViewHolder(v, parent);
        return vh;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        TaskData data = mTaskData.get(position);
        data.setColor(colors[position % colors.length]);
        holder.setData(data);
    }

    // return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mTaskData.size();
    }
}
