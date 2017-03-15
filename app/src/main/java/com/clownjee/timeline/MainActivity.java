package com.clownjee.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.clownjee.timeline.adapter.ItemClickListener;
import com.clownjee.timeline.adapter.TimeLineAdapter;
import com.clownjee.timeline.bean.TimeLineItem;
import com.clownjee.timeline.bean.TimeLineStatus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private List<TimeLineItem> timeLineItems;

    private TimeLineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView timeLineRecyclerView = (RecyclerView) findViewById(R.id.timeLineRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        timeLineRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new TimeLineAdapter(initDatas());
        timeLineRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    private List<TimeLineItem> initDatas() {
        timeLineItems = new ArrayList<>();
        timeLineItems.add(new TimeLineItem( false, TimeLineStatus.FINISH));
        timeLineItems.add(new TimeLineItem(true, TimeLineStatus.TRANSPORTTING));
        timeLineItems.add(new TimeLineItem(false, TimeLineStatus.WAIT));
        timeLineItems.add(new TimeLineItem(false, TimeLineStatus.WAIT));
        timeLineItems.add(new TimeLineItem( false, TimeLineStatus.WAIT));
        timeLineItems.add(new TimeLineItem( false, TimeLineStatus.WAIT));
        timeLineItems.add(new TimeLineItem( false, TimeLineStatus.WAIT));
        timeLineItems.add(new TimeLineItem(false, TimeLineStatus.WAIT));
        return timeLineItems;
    }

    @Override
    public void onItemClick(View view, int position) {
        TimeLineItem timeLineItem = timeLineItems.get(position);
        boolean isSpread = timeLineItem.isSpread();
        for (TimeLineItem lineItem : timeLineItems) {
            lineItem.setSpread(false);
        }
        if (isSpread) {
            timeLineItem.setSpread(false);
        } else {
            timeLineItem.setSpread(true);
        }
        adapter.notifyDataSetChanged();
    }
}
