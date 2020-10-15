package com.example.susa_boba_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Post> mData;

    public MyAdapter(Context context, ArrayList<Post> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater
                .from(mContext)
                .inflate(R.layout.cell_post, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.ivPosterThumbnail = (ImageView) view.findViewById(R.id.ivPosterThumbnail);
        holder.tvPosterName = (TextView) view.findViewById(R.id.tvPosterName);
        holder.tvContent = (TextView) view.findViewById(R.id.tvContent);
        holder.btnLike = (ImageButton) view.findViewById(R.id.btnLike);
        holder.btnComment = (ImageButton) view.findViewById(R.id.btnComment);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = mData.get(position);
        holder.tvPosterName.setText(post.posterName);
        holder.tvContent.setText(post.content);
        Glide.with(mContext)
                .load(post.posterThumbnailUrl)
                .into(holder.ivPosterThumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivPosterThumbnail;
        public TextView tvPosterName;
        public TextView tvContent;
        public ImageButton btnLike;
        public ImageButton btnComment;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
