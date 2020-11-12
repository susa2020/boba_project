package com.example.susa_boba_project;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.susa_boba_project.memo_database.MemoDataBase;
import com.example.susa_boba_project.memo_database.MyData;

import java.util.Arrays;
import java.util.List;

//import com.bumptech.glide.Glide;


public class bubbles_recyclerview_adapter extends RecyclerView.Adapter<bubbles_recyclerview_adapter.ViewHolder> {

    private List<MyData> myData;
    private Activity activity;
    private OnItemClickListener onItemClickListener;

    public bubbles_recyclerview_adapter(Activity activity, List<MyData> myData) {
        this.activity = activity;
        this.myData = myData;
    }
    /**建立對外接口*/
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMemoContent;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMemoContent = itemView.findViewById(android.R.id.text1);
            view = itemView;
        }
    }
    /**更新資料*/
    public void refreshView() {
        new Thread(()->{
            List<MyData> data = Arrays.asList(MemoDataBase.getInstance(activity).getDataDao().loadAllContent());
            this.myData = data;
            activity.runOnUiThread(() -> {
                notifyDataSetChanged();
            });
        }).start();
    }
    /**刪除資料
    public void deleteData(int position){
        new Thread(()->{
            MemoDataBase.getInstance(activity).getDataDao().deleteData(myData.get(position).getId());
            activity.runOnUiThread(()->{
                notifyItemRemoved(position);
                refreshView();
            });
        }).start();
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMemoContent.setText(myData.get(position).getContent());
        holder.view.setOnClickListener((v)->{
            onItemClickListener.onItemClick(myData.get(position));
        });

    }
    @Override
    public int getItemCount() {
        return myData.size();
    }
    /**建立對外接口*/
    public interface OnItemClickListener {
        void onItemClick(MyData myData);
    }


    /*private Context mContext;
    private ArrayList<Memo> mData;

    public bubbles_recyclerview_adapter(Context context, ArrayList<Memo> data) {
        this.mContext = context;
        this.mData = data;
    }

    private List<MyData> myData;
    private Activity activity;
    private MainActivity.MyAdapter.OnItemClickListener onItemClickListener;

    public MyAdapter(Activity activity, List<MyData> myData) {
        this.activity = activity;
        this.myData = myData;
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
    }*/
}
