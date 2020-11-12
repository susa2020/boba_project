package com.example.susa_boba_project.memo_database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DataDao {
    @Insert
    public void insertMemo(MyData...content);

    @Update
    public void UpdateMemo(MyData... content);

    @Delete
    public void DeleteMemo(MyData... content);

    @Query("SELECT * FROM content")
    public MyData[] loadAllContent();


}