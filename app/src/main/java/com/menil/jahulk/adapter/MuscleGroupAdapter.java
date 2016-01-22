package com.menil.jahulk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.menil.jahulk.R;
import com.menil.jahulk.activity.ExcersiceActivity;
import com.menil.jahulk.bus.MuscleGroupEvent;
import com.menil.jahulk.model.MuscleGroup;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.adapter.
 */
public class MuscleGroupAdapter extends RecyclerView.Adapter<MuscleGroupAdapter.ItemViewHolder> {

    Context mContext;
    List<MuscleGroup> data;

    public MuscleGroupAdapter(Context mContext, List<MuscleGroup> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.muscle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.title.setText(data.get(position).getName());
        Picasso.with(mContext)
                .load(data.get(position).getImageLink())
                .fit()
                .into(holder.background);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView background;
        public TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            background = (ImageView) itemView.findViewById(R.id.muscle_background);
            title = (TextView) itemView.findViewById(R.id.muscle_title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            EventBus.getDefault().postSticky(data.get(getLayoutPosition()));
            EventBus.getDefault().postSticky(new MuscleGroupEvent(new ArrayList<MuscleGroup>(data)));
            mContext.startActivity(new Intent(mContext, ExcersiceActivity.class));
        }
    }
}
