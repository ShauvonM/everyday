package com.denyconformity.everyday;

import android.app.ActionBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shauvon on 1/23/2016.
 */
// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class TaskViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    private ViewGroup mParent;
    private CardView mTaskView;
    private TaskData mTaskData;
    private ArrayList<CheckBox> checkBoxes;

    public TaskViewHolder(CardView v, ViewGroup parent) {
        super(v);
        mTaskView = v;
        mParent = parent;
    }
    public void setData (TaskData data) {
        mTaskData = data;
        ((TextView) mTaskView.findViewById(R.id.info_text)).setText(data.getName());
        mTaskView.setCardBackgroundColor(data.getColor());

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        checkBoxes = new ArrayList<CheckBox>(data.getFrequency());
        for(int cnt = 0; cnt < data.getFrequency(); cnt++) {
            CheckBox cb = new CheckBox(mParent.getContext());
            checkBoxes.add(cb);
            ((LinearLayout) mTaskView.findViewById(R.id.checkbox_wrapper)).addView(cb, params);

            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (mTaskData.complete()) {
                            Log.d("ED", "Complete! " + mTaskData.getName());
                        }
                    }
                }
            });
        }

        mTaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ED", "Clicked: " + mTaskData.getName());

                for(int cnt = 0; cnt < checkBoxes.size(); cnt++) {
                    CheckBox cb = checkBoxes.get(cnt);
                    if (!cb.isChecked()) {
                        cb.setChecked(true);
                        cnt = checkBoxes.size();
                    }
                }
            }
        });
    }
}
