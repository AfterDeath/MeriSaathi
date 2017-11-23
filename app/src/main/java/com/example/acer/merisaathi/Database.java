package com.example.acer.merisaathi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TXR on 16/11/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static String DATABASE_NAME="sql.db";
    public static int version=1;
    public static String USER_NUMBER="number";
    public static String USER_NAME="name";
    public static String TABLE_NAME="user";
  //  public static String USER_PASSWORD="password";
    public static String USER_ID="id";
    public Database(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE if not exists `user` (\n" +
                        "\t`number`\tTEXT,\n" +
                        "\t`name`\tTEXT,\n" +

                        "\t`id`\tINTEGER,\n" +
                        "\tPRIMARY KEY(`id`)\n" +
                        ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(User u1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        // cv.put(USER_ID,u1.id);
        cv.put(USER_NUMBER,u1.number);
        cv.put(USER_NAME,u1.name);
        cv.put(USER_ID,u1.id);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }
    public User getdata(int Id) {

        User u=new User();
        String sql = "select * from user where id=Id";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            u.number = cursor.getString(cursor.getColumnIndex("number"));
            u.name = cursor.getString(cursor.getColumnIndex("name"));
           // u.id = cursor.getString(cursor.getColumnIndex("password"));
        }
        return u;
    }

}
