package com.example.susa_boba_project;





/*import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class MemoBubble{
    private SQLiteDatabase db=null;
    private final static String TABLE_NAME="TableMemo";
    private final static String _ID = "_id";
    private final static String MEMO_CONTENT = "memo_content";
    private final static String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+_ID+" INTERGER PRIMARY KEY,"+MEMO_CONTENT+" TEXT )";
    private Context context;
    public MemoBubble(Context context){
        this.context=context;
    }
    public void open() throws SQLException {
        try{
            db = context.openOrCreateDatabase("memobubble.db",Context.MODE_PRIVATE,null);
            db.execSQL(CREATE_TABLE);
        }
        catch (Exception e){
            Toast.makeText(context, "memobubble.db已建立", Toast.LENGTH_SHORT).show();
        }
    }

    public void append(Memo contentmemo){
        String insert_text="INSERT INTO"+TABLE_NAME+"( "+MEMO_CONTENT+") values ("+contentmemo+")";
        db.execSQL(insert_text);//有問題
    }
    public void delete(long id){
        String delete_text = "DELETE FROM "+TABLE_NAME+" WHERE "+_ID+"="+id;
        db.execSQL(delete_text);
    }

    /*這裡有錯 測試需要 暫時註解
    public Cursor select(long id){
        String select_text = "SELECT * FROM " + TABLE_NAME + " WHERE " + _ID + "=" + id;
        Cursor cursor=db.rawQuery(select_text);
        return cursor;
    }*/
    /*public Cursor select_all(){
        String select_text="SELECT * FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(select_text,null);
        return cursor;
    }
}*/