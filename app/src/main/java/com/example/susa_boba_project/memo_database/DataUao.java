package com.example.susa_boba_project.memo_database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataUao {

    String tableName = "MemoTable";
    /**=======================================================================================*/
    /**簡易新增所有資料的方法*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)//預設萬一執行出錯怎麼辦，REPLACE為覆蓋
    void insertData(MyData myData);

    /**複雜(?)新增所有資料的方法*/
    @Query("INSERT INTO "+tableName+"(memo_content,elseInfo) VALUES(:memo_content,:elseData)")
    void insertData(String memo_content,String elseData);

    /**=======================================================================================*/
    /**撈取全部資料*/
    @Query("SELECT * FROM " + tableName)
    List<MyData> displayAll();

    /**撈取某個名字的相關資料*/
    @Query("SELECT * FROM " + tableName +" WHERE memo_content = :memo_content")
    List<MyData> findDataByName(String memo_content);

    /**=======================================================================================*/
    /**簡易更新資料的方法*/
    @Update
    void updateData(MyData myData);

    /**複雜(?)更新資料的方法*/
    @Query("UPDATE "+tableName+" SET memo_content = :memo_content,elseInfo = :elseInfo WHERE id = :id" )
    void updateData(int id,String memo_content,String elseInfo);

    /**=======================================================================================*/
    /**簡單刪除資料的方法*/
    @Delete
    void deleteData(MyData myData);

    /**複雜(?)刪除資料的方法*/
    @Query("DELETE  FROM " + tableName + " WHERE id = :id")
    void deleteData(int id);

}