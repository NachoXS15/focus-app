package com.example.focus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.focus.entities.Items;

import java.util.ArrayList;

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

    public ArrayList<Items> showItems(){
        DbHelper dbhelper = new DbHelper(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ArrayList<Items> listItem = new ArrayList<>();

        Items item = null;
        Cursor cursorItems = null;
        cursorItems = db.rawQuery("SELECT * FROM " + TABLE_ITEMS, null);
        if (cursorItems.moveToFirst()){
            do{
                item = new Items();
                item.setId(cursorItems.getInt(0));
                item.setTitle(cursorItems.getString(1));
                item.setDescr(cursorItems.getString(2));
                item.setDate(cursorItems.getString(3));
                listItem.add(item);
            }while(cursorItems.moveToNext());
        }
        cursorItems.close();
        return listItem;
    }
}
