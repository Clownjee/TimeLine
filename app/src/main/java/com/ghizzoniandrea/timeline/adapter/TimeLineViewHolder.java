package com.ghizzoniandrea.timeline.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ghizzoniandrea.timeline.R;
import com.ghizzoniandrea.timeline.bean.TimeLineItemType;
import com.ghizzoniandrea.timeline.databinding.ItemTimelineBinding;
import com.ghizzoniandrea.timeline.view.TimeLineView;

/**
 * Created by ghizzoniandrea on 2016/3/27.
 */
public class TimeLineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ItemClickListener mListener;

    private Context mContext;

    private ItemTimelineBinding mBinding;

    public TimeLineViewHolder(View itemView, int type, Context context, ItemClickListener listener) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
        this.mListener = listener;
        this.mContext = context;
        TimeLineView timeLineView = mBinding.timeLineView;
        if (type == TimeLineItemType.ONE) {
            timeLineView.setBeginLine(null);
            timeLineView.setEndLine(null);
        } else if (type == TimeLineItemType.START) {
            timeLineView.setBeginLine(null);
        } else if (type == TimeLineItemType.END) {
            timeLineView.setEndLine(null);
        }
        itemView.setOnClickListener(this);
        mBinding.ivArrow.setOnClickListener(this);
        mBinding.tvPhoneNumber.setOnClickListener(this);
    }

    public ItemTimelineBinding getBinding() {
        return mBinding;
    }

    public void setBinding(ItemTimelineBinding binding) {
        mBinding = binding;
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
