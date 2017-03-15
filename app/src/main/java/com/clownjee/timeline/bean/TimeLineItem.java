package com.clownjee.timeline.bean;

/**
 * Created by Clownjee on 2016/3/27.
 */
public class TimeLineItem {

    private boolean spread;
    private int status;

    public TimeLineItem() {
    }

    public TimeLineItem(boolean spread, int status) {
        this.spread = spread;
        this.status = status;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
