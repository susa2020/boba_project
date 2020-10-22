package com.example.susa_boba_project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //進度:資料庫架好功能尚未完成沒意外會報錯
   private final static String _ID = "_id";
   private final static String MEMO_CONTENT = "memo_content";
   //private LastView lstView;
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
       // UpdateListView(cursor);

        //recrclerview start
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bubbles_recyclerView);

        ArrayList<Memo> data = new ArrayList<>();
        data.add(new Memo("Marshmallow"));//test
        data.add(new Memo("Lollipop"));//test

        bubbles_recyclerview_adapter adapter = new bubbles_recyclerview_adapter(this, data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //recyclerview end
    }

    private void findViews(){
        //建立lisener
        //類別偵聽氣
        //onItemLongClick未完成
        //onClicker未完成
    }
   /* public void UpdateListView(Cursor memocursor){
        bubbles_recyclerview_adapter adapter = new bubbles_recyclerview_adapter(memocursor);
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
        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View view, ViewGroup viewGroup){
            View getview = view;
            cursor.moveToPosition(position);
            getview = getLayoutInflater().inflate(R.layout.activity_main,null);
            //getview未完成
            return getview;
        }

    }*/
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
        Intent it = new Intent(this, SettingsActivity.class); //creat intent and set the activity
        startActivity(it); // go to second activity

    }


}