package com.example.susa_boba_project;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.susa_boba_project.memo_database.DataBase;
import com.example.susa_boba_project.memo_database.MyData;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //進度:資料庫架好功能尚未完成沒意外會報錯
    bubbles_recyclerview_adapter myAdapter;
    MyData nowSelectedData;//取得在畫面上顯示中的資料內容
    private Cursor cursor;
    boolean addBuddleButtonHasBeenClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);//設置資料庫監視

        ImageButton btnAdd = findViewById(R.id.addBubbleButton);
        Button btModify = findViewById(R.id.button_Modify);
        Button btClear = findViewById(R.id.button_Clear);
        EditText edMemo = findViewById(R.id.type_memo);
        //EditText edElseInfo = findViewById(R.id.editText_else);
        RecyclerView recyclerView = findViewById(R.id.bubbles_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//設置分隔線

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//設置分隔線
        //setRecyclerFunction(recyclerView);//設置RecyclerView左滑刪除


        /*findViews();
        db = new MemoBubble(MainActivity.this);
        db.open();
        cursor = db.select_all();
        UpdateListView(cursor);*/

        /**初始化RecyclerView*/
        new Thread(() -> {
            List<MyData> data = DataBase.getInstance(this).getDataUao().displayAll();
            myAdapter = new bubbles_recyclerview_adapter(this, data);
            runOnUiThread(() -> {
                recyclerView.setAdapter(myAdapter);
                /**===============================================================================*/
                myAdapter.setOnItemClickListener(new bubbles_recyclerview_adapter.OnItemClickListener() {//原本的樣貌
                    @Override
                    public void onItemClick(MyData myData) {}
                });
                /**===============================================================================*/
                /**取得被選中的資料，並顯示於畫面*/
                myAdapter.setOnItemClickListener((myData)-> {//匿名函式(原貌在上方)
                    nowSelectedData = myData;
                    edMemo.setText(myData.getName());
                    //edElseInfo.setText(myData.getElseInfo());
                });
                /**===============================================================================*/
            });
        }).start();
        /**=======================================================================================*/

    }
    /*private btnAdd.OnClickListener addThingToList =
            new btnAdd.OnclickListener(){
            @Override
                public void onClick( View  v ){
                    addBuddleButtonHasBeenClicked = true;
                    Intent intent = new intent;
                    intent.setClass( MainActivity.this , addThingPage.class );
                    String showedThing;
                    startActivity( intent );
                }
            }
     */




    private void findViews(){
        //建立listener
        //類別偵聽器
        //onItemLongClick未完成
        //onClicker未完成
    }
    /*public void UpdateListView(Cursor memocursor){
        MyAdapter adapter = new MyAdapter(memocursor);
        adapter.notifyDataSetChanged();
        lstView.setAdapter(adapter);
        cursor = memocursor;
    }*/
    /*public class MyaAdapter extends BaseAdapter{
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
    }


}
