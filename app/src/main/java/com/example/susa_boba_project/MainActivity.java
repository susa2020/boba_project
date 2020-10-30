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
   private Button btnappend,btnUpdate,btnSelect;
   private TextInputEditText edtId,edtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // UpdateListView(cursor);
        //recrclerview start

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.bubbles_recyclerView);

        ArrayList<Memo> data = new ArrayList<>();
        data.add(new Memo("Marshmallow"));//test
        data.add(new Memo("Lollipop"));//test

        bubbles_recyclerview_adapter adapter = new bubbles_recyclerview_adapter(this, data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //recyclerview end
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
        Intent it = new Intent(this, SettingsActivity.class); //creat intent and set the activity
        startActivity(it); // go to second activity

    }

}