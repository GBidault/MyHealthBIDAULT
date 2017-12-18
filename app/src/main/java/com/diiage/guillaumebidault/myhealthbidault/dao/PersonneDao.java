package com.diiage.guillaumebidault.myhealthbidault.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.diiage.guillaumebidault.myhealthbidault.beans.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GuillaumeBidault on 17/11/2017.
 */

public class PersonneDao {

    private SQLiteDatabase mSQLiteDapaBase;
    private DataBaseHelper mDbHelper;

    public PersonneDao(Context context){
        mDbHelper=new DataBaseHelper(context);
    }

    public void open() throws SQLException {
        mSQLiteDapaBase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mSQLiteDapaBase.close();
    }

    public List<Personne> getPersonnes(){
        List<Personne> personnes=new ArrayList<>();
        Cursor cursor = mSQLiteDapaBase.query("personne",new String[]{"*"},null, null,null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Personne persone=new Personne(cursor);
            personnes.add(persone);
            cursor.moveToNext();
        }
        return personnes;
    }

    public Cursor getPersonnesCursor(){
        return mSQLiteDapaBase.query("personne",new String[]{"*"},null, null,null, null, null);
    }

    public Cursor getPersonneCursorById(int id){
        return mSQLiteDapaBase.query("personne",new String[]{"*"},"idPersonne",new String[]{String.valueOf(id)},null,null,null,null);
    }
}
