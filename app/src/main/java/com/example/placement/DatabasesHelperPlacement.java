package com.example.placement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabasesHelperPlacement extends SQLiteOpenHelper {
    public DatabasesHelperPlacement(Context context) {
        super(context, "placement.db", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("Create table placementdetails(name text, rollno text primary key, marks10 text, marks12 text, graduation text, pgraduation text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("drop table if exists placementdetails");
    }
    public boolean insert(String name, String rollno, String marks10, String marks12, String graduation , String pgraduation)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("rollno", rollno);
        contentValues.put("marks10", marks10);
        contentValues.put("marks12",marks12);
        contentValues.put("graduation", graduation);
        contentValues.put("pgraduation", pgraduation);
        long ins=database.insert("placementdetails",null, contentValues);
        if(ins==-1)
            return  false;
        else
            return true;

    }
    public boolean chkerol(String roll)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("Select * from placementdetails where rollno=?", new String[]{roll});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}
