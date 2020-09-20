package com.example.susa_boba_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //進度:資料庫架好功能尚未完成沒意外會報錯
   private final static String _ID = "_id";
   private final static String MEMO_CONTENT = "memo_content";
   private LastView lstView;
   private Button btnappend,btnUpdate,btnSelect;
   private TextInputEditText edtId,edtContent;
   private MemoBubble db = new MemoBubble(MainActivity.this);
   private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        db = new MemoBubble(MainActivity.this);
        db.open();
        cursor = db.select_all();
        UpdateListView(cursor);
    }
    private void findViews(){
        //建立lisener
        //類別偵聽氣
        //onItemLongClick未完成
        //onClicker未完成
    }
    public void UpdateListView(Cursor memocursor){
        MyAdapter adapter = new MyAdapter(memocursor);
        adapter.notifyDataSetChanged();
        lstView.setAdapter(adapter);
        cursor = memocursor;
    }
    public class MyaAdapter extends BaseAdapter{
        private Cursor cursor;
        public MyaAdapter(Cursor cursor){
            this.cursor=cursor;
        }
        @Override
        public int getCount(){
            return cursor.getCount();
        }
        @Override
        public Object getItem(int position){
            return null;
        }
        @Override
        public long getItemId(int position){
            cursor.moveToPosition(position);
            return cursor.getInt(0);
        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            View getview = view;
            cursor.moveToPosition(position);
            getview = getLayoutInflater().inflate(R.layout.activity_main,null);
            //getview未完成
            return getview;
        }

    }
    public void add_bubble_clicked(View view) {
        Toast toast = Toast.makeText(this, "新增按鈕已經被點擊", Toast.LENGTH_SHORT);
        toast.show();

    }
    public void edit_button_clicked(View view) {
        Toast toast = Toast.makeText(this, "編輯按鈕已經被點擊", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void more_clicked(View view) {
        Toast toast = Toast.makeText(this, "更多按鈕已經被點擊", Toast.LENGTH_SHORT);
        toast.show();
    }
\


}