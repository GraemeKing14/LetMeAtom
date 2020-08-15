package com.example.layout_idea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    /** A class to create the userInfo database. Inherits methods from the SQLiteOpenHelper class. **/

    private static final String Database_Name = "userInfo.db";
    private static final String Table_Name = "userInfo";
    private static final String Column1_Name = "ID";
    private static final String Column2_Name = "Username";
    private static final String Column3_Name = "Password";

    public DatabaseHelper(Context context) {
        /** Simple constructor for this class. **/
        super(context, Database_Name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        /** Creates database according to developer specifications. **/
        db.execSQL("CREATE TABLE userInfo (ID Integer PRIMARY KEY AUTOINCREMENT, Username TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /** Method to drop and recreate the database if a new version is required. **/
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    public long addUser(String username, String password) {
        /** A method which adds a user with specific username and password to the database. **/
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username", username);
        contentValues.put("Password", password);
        long res = db.insert(Table_Name, null, contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password) {
        /** A method which checks whether a user with a specific password and username exists
        in the database. **/
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = { Column1_Name };
        String selection = Column2_Name + " = ?" + " and " + Column3_Name + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(Table_Name,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
}
