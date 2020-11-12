package com.example.susa_boba_project.memo_database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MemoDB")
public class MyData {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}