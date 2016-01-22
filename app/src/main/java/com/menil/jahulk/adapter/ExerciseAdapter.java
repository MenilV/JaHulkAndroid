package com.menil.jahulk.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.menil.jahulk.R;
import com.menil.jahulk.activity.ExcersiceActivity;
import com.menil.jahulk.activity.VideoDemo;
import com.menil.jahulk.model.ExerciseModel;

import java.util.List;

/**
 * Created by Menil V. on 22.1.2016 at com.menil.jahulk.adapter.
 */
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ItemViewHolder> {

    private List<ExerciseModel> data;
    private Context mContext;

    public ExerciseAdapter(Context context, List<ExerciseModel> data) {
        this.data = data;
        this.mContext = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.exercise_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.group.setText(data.get(position).getGroup().getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name, group;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.exercise_name);
            group = (TextView) itemView.findViewById(R.id.exercise_group);
        }

        @Override
        public void onClick(View v) {
            mContext.startActivity(new Intent(mContext, ExcersiceActivity.class));
        }
    }

}
