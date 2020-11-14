package com.example.susa_boba_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.susa_boba_project.memo_database.MemoDataBase;
import com.example.susa_boba_project.memo_database.MyData;
import com.facebook.stetho.Stetho;
import com.google.android.material.textfield.TextInputEditText;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity {
   private Button btnappend,btnUpdate,btnSelect;
   private TextInputEditText edtId,edtContent;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // UpdateListView(cursor);
        //recrclerview start
        Stetho.initializeWithDefaults(this);//設置資料庫監視

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bubbles_recyclerView);

        new Thread(() -> {
            MyData[] data= MemoDataBase.getInstance(getApplicationContext()).getDataDao().loadAllContent();
                runOnUiThread(() -> {
                    bubbles_recyclerview_adapter adapter = new bubbles_recyclerview_adapter(this, data);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setAdapter(adapter);
                });
        }).start();

        new Thread(() -> {
            MyData memo=new MyData();
            memo.setContent("aaaaa");
            MemoDataBase.getInstance(getApplicationContext()).getDataDao().insertMemo(memo);
            MyData[] data= MemoDataBase.getInstance(getApplicationContext()).getDataDao().loadAllContent();
            runOnUiThread(() -> {
                bubbles_recyclerview_adapter adapter = new bubbles_recyclerview_adapter(this, data);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
            });
        }).start();

        //List<MyData> data = Arrays.asList(MemoDataBase.getInstance(this).getDataDao().loadAllContent());



        //recyclerview end
    }

    public void add_bubble_clicked(View view) {
        Toast toast = Toast.makeText(this, "新增按鈕已經被點擊", Toast.LENGTH_SHORT);
        toast.show();
        initPopWindow(view);
    }


    public void edit_button_clicked(View view) {
        Toast toast = Toast.makeText(this, "編輯按鈕已經被點擊", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void more_clicked(View view) {
        Toast toast = Toast.makeText(this, "更多按鈕已經被點擊", Toast.LENGTH_SHORT);
        toast.show();
        Intent it = new Intent(this, SettingsActivity.class); //creat intent and set the activity
        startActivity(it); // go to second activity

    }

    private void initPopWindow(View v) {
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentview = inflater.inflate(R.layout.pop_up_memo_added, null);
        contentview.setFocusable(true); // 这个很重要
        contentview.setFocusableInTouchMode(true);
        final PopupWindow popupWindow = new PopupWindow(contentview, WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        contentview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    popupWindow.dismiss();

                    return true;
                }
                return false;
            }
        });
        popupWindow.showAtLocation(v,  Gravity.BOTTOM, 0, 0);


    }
}