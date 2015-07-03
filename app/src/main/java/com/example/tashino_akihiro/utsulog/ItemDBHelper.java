package com.example.tashino_akihiro.utsulog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akihiro on 2015/05/30.
 */
public class ItemDBHelper extends SQLiteOpenHelper {
    public ItemDBHelper(Context context){
        super(context, "lifedata.db", null, 2);
        //item.dbは　ANDROIDのDBファイル名として保存します。
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL="create table lifedata("
                +"_id integer primary key autoincrement,"
                +"judge text,"
                +"comment text,"
                +"date text,"
                +"level Integer)";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists lifedata");
        onCreate(db);
    }

    public long insert(String judge,String comment,String date,int level){
        ContentValues values=new ContentValues();
        values.put("judge",judge);
        values.put("comment",comment);
        values.put("date",date);
        values.put("level",level);

        SQLiteDatabase db = getWritableDatabase();
        long pk = db.insert("lifedata",null,values);
        db.close();
        return pk;
    }

    public List<ItemBean> select(){
        SQLiteDatabase database = getReadableDatabase();
        String[] columns = {"_id","judge","comment","date","level"};
        Cursor cursor=database.query("lifedata",columns,null,null,null,null,null);

        List<ItemBean> list = new ArrayList<ItemBean>();
        while(cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex("_id"));
            String judge = cursor.getString(cursor.getColumnIndex("judge"));
            String comment = cursor.getString(cursor.getColumnIndex("comment"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            int level = cursor.getInt(cursor.getColumnIndex("level"));

            ItemBean bean = new ItemBean(id,judge,comment,date,level);
            list.add(bean);
        }
        cursor.close();
        database.close();
        return list;
    }

    public int delete(long id){
        SQLiteDatabase db = getWritableDatabase();
        String[] whereArgs={String.valueOf(id)};
        int raws = db.delete("lifedata","_id=?",whereArgs);
        db.close();
        return raws;
    }
    public Cursor selectCursor() {
        // 読み込み用としてDBをオープンする
        SQLiteDatabase database = getReadableDatabase();
        String[] columns = {"_id","judge","comment","date","level"};
        Cursor cursor=database.query("lifedata", columns, null, null, null, null, null);

        return cursor;
    }
}
