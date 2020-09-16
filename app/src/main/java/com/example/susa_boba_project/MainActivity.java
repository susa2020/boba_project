package com.example.susa_boba_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}