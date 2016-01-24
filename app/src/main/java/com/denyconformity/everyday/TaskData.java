package com.denyconformity.everyday;

/**
 * Created by Shauvon on 1/23/2016.
 */
public class TaskData {
    private String name;
    private int frequency;
    private int color;
    private int completeCount;

    public TaskData(String n, Integer f) {
        this.name = n;
        this.frequency = f;
        this.completeCount = 0;
    }

    public String getName () {
        return this.name;
    }

    public int getFrequency () {
        return this.frequency;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = android.graphics.Color.parseColor(color);
    }

    public boolean complete() {
        completeCount++;
        return completeCount >= frequency;
    }

    public int getCompleteCount() {
        return completeCount;
    }
}
