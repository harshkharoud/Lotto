package com.example.lotto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {

    // using Constants for column names
/*https://sqlitebrowser.org/dl/*/
    private static final String DATABASE_NAME = "LottoDb.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "registration";
    private static final String TABLE_NAME_MONEY = "money";
    private static final String TABLE_NAME_ADMIN = "admin_pool";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_PASSWORD = "password ";
    private static final String COLUMN_AMOUNT = "amount ";

    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    String sql = "CREATE TABLE " + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " varchar(200) NOT NULL, " +
            COLUMN_MOBILE + " varchar(200) NOT NULL, " +
            COLUMN_AGE + "  INTEGER NOT NULL, " +
            COLUMN_PASSWORD + " varchar(200) NOT NULL);";
    String sql_money = "CREATE TABLE " + TABLE_NAME_MONEY + "(" +
            COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_MOBILE + " varchar(200) NOT NULL, " +
            COLUMN_AMOUNT + "  varchar(200) NOT NULL);";
    String sql_admin_pool = "CREATE TABLE " + TABLE_NAME_ADMIN + "(" +
            COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_AMOUNT + "  varchar(200) NOT NULL);";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);
        db.execSQL(sql_money);
        db.execSQL(sql_admin_pool);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
         * we are just dropping the table and recreate it
         * */
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(sql);
        String sql_money = "DROP TABLE IF EXISTS " + TABLE_NAME_MONEY + ";";
        db.execSQL(sql_money);
        String sql_admin_pool = "DROP TABLE IF EXISTS " + TABLE_NAME_ADMIN + ";";
        db.execSQL(sql_admin_pool);
        onCreate(db);
    }
    boolean register(String name, String mobile, String age, String password) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MOBILE, mobile);
        cv.put(COLUMN_AGE,age);
        cv.put(COLUMN_PASSWORD, password);

        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.insert(TABLE_NAME, null, cv) != -1;
//        return true;
    }


    boolean add_money(String mobile, String amount) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value
        cv.put(COLUMN_MOBILE, mobile);
        cv.put(COLUMN_AMOUNT,amount);

        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.insert(TABLE_NAME_MONEY, null, cv) != -1;
//        return true;
    }
    boolean update_money(String mobile, String amount) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value
        cv.put(COLUMN_MOBILE, mobile);
        cv.put(COLUMN_AMOUNT,amount);


        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.update(TABLE_NAME_MONEY, cv, COLUMN_MOBILE + "=?", new String[]{String.valueOf(mobile)}) > 0;

//        return true;
    }


    public Cursor show(String mobile)
    {
        //get the data from table
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor q=db.rawQuery("SELECT amount FROM money WHERE mobile = ?", new String[] {mobile},null);
        return  q;

    }
    boolean admin_pool(String amount) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value
        cv.put(COLUMN_AMOUNT,amount);

        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.insert(TABLE_NAME_ADMIN, null, cv) != -1;
//        return true;
    }
    public Cursor show_pool()
    {
        //get the data from table
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor q=db.rawQuery("SELECT amount FROM admin_pool ",null);
        return  q;

    }
    boolean update_pool(String amount) {

        // in order to insert items into database, we need a writable database
        // this method returns a SQLite database instance
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // we need to define a contentValues instance
        ContentValues cv = new ContentValues();

        // the first argument of the put method is the column name and the second the value

        cv.put(COLUMN_AMOUNT,amount);


        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.update(TABLE_NAME_ADMIN, cv, COLUMN_ID + "=?", new String[]{String.valueOf(1)}) > 0;

//        return true;
    }



    public boolean checkUser(String mobile, String password) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_MOBILE + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {mobile, password};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkMobileNo(String mobile) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_MOBILE + " = ?";
        // selection arguments
        String[] selectionArgs = {mobile};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

}
