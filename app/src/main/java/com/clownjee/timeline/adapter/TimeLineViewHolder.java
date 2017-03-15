package com.clownjee.timeline.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.clownjee.timeline.R;
import com.clownjee.timeline.bean.TimeLineItem;
import com.clownjee.timeline.bean.TimeLineItemType;
import com.clownjee.timeline.bean.TimeLineStatus;
import com.clownjee.timeline.view.TimeLineView;

/**
 * Created by Clownjee on 2016/3/27.
 */
public class TimeLineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private LinearLayout llyt1;
    private LinearLayout llytItem;
    private ImageView ivArrow;
    private TextView tvPhoneNumber;

    private ItemClickListener mListener;

    private TimeLineView timeLineView;

    private Context mContext;

    public TimeLineViewHolder(View itemView, int type, Context context, ItemClickListener listener) {
        super(itemView);
        this.mListener = listener;
        this.mContext = context;
        llyt1 = (LinearLayout) itemView.findViewById(R.id.llyt1);
        llytItem = (LinearLayout) itemView.findViewById(R.id.llyt_item);
        ivArrow = (ImageView) itemView.findViewById(R.id.iv_arrow);
        tvPhoneNumber = (TextView) itemView.findViewById(R.id.tv_phone_number);
        timeLineView = (TimeLineView) itemView.findViewById(R.id.timeLineView);
        if (type == TimeLineItemType.ONE) {
            timeLineView.setBeginLine(null);
            timeLineView.setEndLine(null);
        } else if (type == TimeLineItemType.START) {
            timeLineView.setBeginLine(null);
        } else if (type == TimeLineItemType.END) {
            timeLineView.setEndLine(null);
        }
        itemView.setOnClickListener(this);
        ivArrow.setOnClickListener(this);
        tvPhoneNumber.setOnClickListener(this);
    }

    public void setData(TimeLineItem timeLineItem) {
        if (timeLineItem.isSpread()) {
            llytItem.setBackgroundColor(Color.parseColor("#FAFAFA"));
            llyt1.setVisibility(View.VISIBLE);
            ivArrow.setImageResource(R.drawable.arrow_up);
        } else {
            llytItem.setBackgroundColor(Color.parseColor("#FFFFFF"));
            llyt1.setVisibility(View.GONE);
            ivArrow.setImageResource(R.drawable.arrow_down);
        }

        switch (timeLineItem.getStatus()) {
            case TimeLineStatus.TRANSPORTTING:
                timeLineView.setTimeLineMarker(ContextCompat.getDrawable(mContext, R.drawable.transportting));
                break;
            case TimeLineStatus.WAIT:
                timeLineView.setTimeLineMarker(ContextCompat.getDrawable(mContext, R.drawable.wait));
                break;
            case TimeLineStatus.FINISH:
                timeLineView.setTimeLineMarker(ContextCompat.getDrawable(mContext, R.drawable.finish));
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_arrow:
                mListener.onItemClick(v, getLayoutPosition());
                break;
            case R.id.tv_phone_number:
                Toast.makeText(mContext, "打电话", Toast.LENGTH_SHORT).show();
                break;

            default:
                if (mListener != null) {
                    mListener.onItemClick(v, getAdapterPosition());
                }
                break;
        }
    }
}
