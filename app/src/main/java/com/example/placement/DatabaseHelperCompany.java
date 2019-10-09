package com.example.placement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperCompany extends SQLiteOpenHelper {
    public DatabaseHelperCompany(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"placement.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("Create table companydetails(compname text, location text, payscale text, bond text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("drop table if exists companydetails");
    }
    public boolean insert(String compname, String location, String payscale, String bond)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("compname", compname);
        contentValues.put("location", location);
        contentValues.put("payscale", payscale );
        contentValues.put("bond",bond);
       long ins=database.insert("companydetails", null, contentValues);
        if(ins==-1)
            return  false;
        else
            return true;
    }
    public boolean chkecompname(String compname)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("Select * from companydetails where compname=?", new String[]{compname});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }
}
