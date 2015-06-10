package com.kot32.warmenglish.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kot32.warmenglish.R;
import com.kot32.warmenglish.model.MainFunctionTypeButtonModel;
import com.kot32.warmenglish.view.ProblemsPage;

/**
 * Created by kot32 on 15/6/1.
 */
public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainViewHolder> {

    private Context context;
    private MainFunctionTypeButtonModel[] models;

    public MainPageAdapter(Context context, MainFunctionTypeButtonModel[] models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(View.inflate(context, R.layout.main_item, null));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //设定绑定后的数据展示逻辑
        holder.image.setBackgroundResource(models[position].getImage_source());
        holder.textView.setText(models[position].getFuction_name());

    }

    @Override
    public int getItemCount() {
        return models.length;
    }

    public  class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.main_bg);
            textView = (TextView) itemView.findViewById(R.id.main_name);
            itemView.setOnClickListener(this);

        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public void onClick(View v) {
            switch (getLayoutPosition()) {
                case 0:
                    Intent intent = new Intent(context, ProblemsPage.class);
                    context.startActivity(intent);
                    break;
            }
        }
    }
}
