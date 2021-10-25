package android.example.sqlitedbm.dbms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.sqlitedbm.model.Contact;
import android.example.sqlitedbm.params.Parameters;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context) {
        super(context, Parameters.DB_NAME, null, Parameters.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Sequel to run query to bring/delete/run data from database
     String create = "CREATE TABLE" + Parameters.TABLE_NAME + "("
             + Parameters.KEY_ID + "INTEGER PRIMARY KEY" + Parameters.KEY_NAME
             + " TEXT, " + Parameters.KEY_PHONE +" TEXT " + ")";
    Log.d("dbms" , "Query being run is : " + create);
    db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put(Parameters.KEY_NAME, contact.getName());
        values.put(Parameters.KEY_PHONE, contact.getPhonenumber());

        db.insert(Parameters.TABLE_NAME, null, values);
        Log.d("dbms", "Successfully inserted the contacts");

        db.close();

    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Generates query to read from the database
        String select = "SELECT * FROM " + Parameters.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);

        // Loop through now
        // cursor position
        if(cursor.moveToFirst()){
            // atleast one time it should get executed
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhonenumber(cursor.getString(2));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        return contactList;

    }

    public int updateContact(Contact contact){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Parameters.KEY_NAME, contact.getName());
        contentValues.put(Parameters.KEY_PHONE, contact.getPhonenumber());

        // Updating the contact list through query
         return database.update(Parameters.TABLE_NAME, contentValues,
                 Parameters.KEY_ID +
                  "=?", new String[]{String.valueOf(contact.getId())});


    }

}