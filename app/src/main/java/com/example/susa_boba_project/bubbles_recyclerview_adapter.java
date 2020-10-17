package com.example.susa_boba_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class bubbles_recyclerview_adapter extends RecyclerView.Adapter<bubbles_recyclerview_adapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Memo> mData;

    public bubbles_recyclerview_adapter(Context context, ArrayList<Memo> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater
                .from(mContext)
                .inflate(R.layout.bubbles, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.tvMemoContent = (TextView) view.findViewById(R.id.memo_content);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Memo post = mData.get(position);
        holder.tvMemoContent.setText(post.memoContent);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        //tvMemoContent text view Memo content
        public TextView tvMemoContent;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
