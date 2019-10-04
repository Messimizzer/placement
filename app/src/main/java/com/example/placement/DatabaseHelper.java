package com.example.placement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
            super(context, "placement.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table userregi(name text, email text primary key, password text, gender text, dob text, phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists userregi");
    }
    //inserting in database
    public boolean insert(String name, String email, String password, String gender, String dob, String phone)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);;
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("gender", gender);
        contentValues.put("dob", dob);
        contentValues.put("phone", phone);
        long ins=database.insert("userregi",null, contentValues);
        if(ins==-1)return false;
        else
                return  true;
    }
    //checking if email exists;
    public Boolean chkemai(String email)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("Select * from userregi where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }


}
