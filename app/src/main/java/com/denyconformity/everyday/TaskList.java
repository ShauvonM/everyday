package com.denyconformity.everyday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<TaskData> TaskDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.main_task_view);

        // this improves performance if the recyclerview doesn't change size
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        TaskDataset = new ArrayList<TaskData>();
        TaskDataset.add(new TaskData("Take out the trash", 2));
        TaskDataset.add(new TaskData("Clean the litter boxes", 2));
        TaskDataset.add(new TaskData("Laugh", 2));
        TaskDataset.add(new TaskData("Water the plants", 2));
        TaskDataset.add(new TaskData("Floss", 2));
        TaskDataset.add(new TaskData("Do ten pushups", 2));

        // specify an adapter
        mAdapter = new MyAdapter(TaskDataset);
        mRecyclerView.setAdapter(mAdapter);

        // this could handle sorting maybe?
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
