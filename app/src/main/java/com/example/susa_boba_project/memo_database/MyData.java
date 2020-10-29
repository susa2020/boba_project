package com.example.susa_boba_project.memo_database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "MemoTable")//這邊要先取好table的名字，稍後的table設置必須與他相同
public class MyData {


    @PrimaryKey(autoGenerate = true)//設置是否使ID自動累加
    private int id;
    private String memo_content;
    private String elseInfo;

    public MyData(String memo_content, String elseInfo) {
        this.memo_content = memo_content;
        this.elseInfo = elseInfo;
    }
    @Ignore//如果要使用多形的建構子，必須加入@Ignore
    public MyData(int id, String memo_content, String elseInfo) {
        this.id = id;
        this.memo_content = memo_content;
        this.elseInfo = elseInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return memo_content;
    }

    public void setName(String memo_content) {
        this.memo_content = memo_content;
    }


    public String getElseInfo() {
        return elseInfo;
    }

    public void setElseInfo(String elseInfo) {
        this.elseInfo = elseInfo;
    }
}