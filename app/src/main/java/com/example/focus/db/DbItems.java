package com.example.focus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbItems extends DbHelper{
    Context context;
    public DbItems(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long addItems(String title, String descr, String date){

        long id = 0;
        try{
            DbHelper dbhelper = new DbHelper(context);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("title", title);
            values.put("descr", descr);
            values.put("date", date);
            id = db.insert(TABLE_ITEMS, null, values);
        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
