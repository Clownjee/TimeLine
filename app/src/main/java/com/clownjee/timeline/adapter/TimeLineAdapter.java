package com.clownjee.timeline.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.clownjee.timeline.R;
import com.clownjee.timeline.bean.TimeLineItem;
import com.clownjee.timeline.bean.TimeLineItemType;
import com.clownjee.timeline.bean.TimeLineStatus;
import com.clownjee.timeline.databinding.ItemTimelineBinding;

import java.util.List;

/**
 * Created by Clownjee on 2016/3/27.
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private List<TimeLineItem> timeLineItems;

    private ItemClickListener mItemClickListener;

    private Context mContext;

    public TimeLineAdapter(Context context, List<TimeLineItem> timeLineItems) {
        this.mContext = context;
        this.timeLineItems = timeLineItems;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTimelineBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_timeline, parent, false);
        return new TimeLineViewHolder(binding.getRoot(), viewType, parent.getContext(), mItemClickListener);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        TimeLineItem timeLineItem = timeLineItems.get(position);
        holder.getBinding().setData(timeLineItem);
        switch (timeLineItem.getStatus()) {
            case TimeLineStatus.TRANSPORTTING:
                holder.getBinding().timeLineView.setTimeLineMarker(ContextCompat.getDrawable(mContext, R.drawable.transportting));
                break;
            case TimeLineStatus.WAIT:
                holder.getBinding().timeLineView.setTimeLineMarker(ContextCompat.getDrawable(mContext, R.drawable.wait));
                break;
            case TimeLineStatus.FINISH:
                holder.getBinding().timeLineView.setTimeLineMarker(ContextCompat.getDrawable(mContext, R.drawable.finish));
                break;

            default:
                break;
        }
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return timeLineItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        int size = timeLineItems.size() - 1;
        if (size == 0) {
            return TimeLineItemType.ONE;
        } else if (position == 0) {
            return TimeLineItemType.START;
        } else if (position == size) {
            return TimeLineItemType.END;
        } else {
            return TimeLineItemType.NORMAL;
        }
    }
}
