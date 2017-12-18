package com.diiage.guillaumebidault.myhealthbidault.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.diiage.guillaumebidault.myhealthbidault.beans.Personne;

import java.util.Date;

/**
 * Created by GuillaumeBidault on 17/11/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME ="myhealthdtb.sql";
    private static final int DATABASE_VERSION=1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlRequette="CREATE TABLE personne (idPersonne INT PRIMARY KEY NOT NULL, nomPersonne VARCHAR NOT NULL, prenomPersonne VARCHAR NOT NULL, agePersonne INT NOT NULL, poidsPersonne INT NOT NULL, dateMajPersonne DATE NOT NULL, loginPersonne VARCHAR NOT NULL);";
        sqLiteDatabase.execSQL(sqlRequette);
        Personne guillaume=new Personne(0,"Bidault","Guillaume",29,89,new Date(),"bidbid21");
        sqLiteDatabase.insert("personne",null,guillaume.getContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
