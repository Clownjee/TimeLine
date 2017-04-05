package com.ghizzoniandrea.timeline.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ghizzoniandrea.timeline.BR;

/**
 * Created by ghizzoniandrea on 2016/3/27.
 */
public class TimeLineItem extends BaseObservable {

    private boolean spread;
    private int status;

    public TimeLineItem() {
    }

    public TimeLineItem(boolean spread, int status) {
        this.spread = spread;
        this.status = status;
    }

    @Bindable
    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
        notifyPropertyChanged(BR.spread);
    }

    @Bindable
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }
}
