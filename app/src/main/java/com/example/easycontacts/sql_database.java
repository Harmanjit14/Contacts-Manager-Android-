package com.example.easycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class sql_database extends SQLiteOpenHelper {
    public sql_database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_V);
    }

    private static final int DATABASE_V = 1;
    private static final String DATABASE_NAME = "contactsDB";
    private static final String TABLE_NAME = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE_NO = "phone_no";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "create table "+TABLE_NAME+" ( "+ID+" integer primary key autoincrement, "+NAME+" text, "+PHONE_NO+" text)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//FUNCTION TO ADD CONTACTS
    public void add_contact(class_contacts c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,c.getName());
        values.put(PHONE_NO,c.getPhone());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
//FUNCTION TO GET SINGLE CONTACT
    public class_contacts get_contact(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID,NAME,PHONE_NO},ID +" =?",new String[] {String.valueOf(id)},null,null,null,null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
            class_contacts data = new class_contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
            return data;
    }
//GET ALL CONTACTS
    public List<class_contacts> getAll_contacts()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        List<class_contacts> contacts = new ArrayList<>();
        String select = "select * from "+ TABLE_NAME;
        Cursor cursor = db.query(select,null,null,null,null,null,null);
        if (cursor.moveToFirst())
        {
            do{
                    class_contacts contacts1 = new class_contacts();
                    contacts1.setId(Integer.parseInt(cursor.getString(0)));
                    contacts1.setName(cursor.getString(1));
                    contacts1.setPhone(cursor.getString(2));
                    contacts.add(contacts1);
            }while (cursor.moveToNext());
        }
        return contacts;
    }

//UPDATE ANY CONTACT

//DELETE ANY CONTACT
}
