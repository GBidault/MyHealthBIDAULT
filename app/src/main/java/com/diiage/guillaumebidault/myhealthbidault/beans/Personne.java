package com.diiage.guillaumebidault.myhealthbidault.beans;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

/**
 * Created by GuillaumeBidault on 17/11/2017.
 */

public class Personne {

    int idPersonne;
    String nomPersonne;
    String prenomPersonne;
    int agePersonne;
    int poidsPersonne;
    Date dateMajPersonne;
    String loginPersonne;

    public Personne(int idPersonne, String nomPersonne, String prenomPersonne, int agePersonne, int poidsPersonne, Date dateMajPersonne, String loginPersonne) {
        this.idPersonne = idPersonne;
        this.nomPersonne = nomPersonne;
        this.prenomPersonne = prenomPersonne;
        this.agePersonne = agePersonne;
        this.poidsPersonne = poidsPersonne;
        this.dateMajPersonne = dateMajPersonne;
        this.loginPersonne = loginPersonne;
    }

    public Personne(Cursor cursor){
        this.idPersonne = cursor.getInt(0);
        this.nomPersonne = cursor.getString(1);
        this.prenomPersonne = cursor.getString(2);
        this.agePersonne = cursor.getInt(3);
        this.poidsPersonne = cursor.getInt(4);
        this.dateMajPersonne = new Date(cursor.getInt(5));
        this.loginPersonne = cursor.getString(6);
    }

    public ContentValues getContentValues(){
        ContentValues contentValues=new ContentValues();
        contentValues.put("idPersonne",idPersonne);
        contentValues.put("nomPersonne",nomPersonne);
        contentValues.put("prenomPersonne",prenomPersonne);
        contentValues.put("agePersonne",agePersonne);
        contentValues.put("poidsPersonne",poidsPersonne);
        contentValues.put("dateMajPersonne",dateMajPersonne.getTime());
        contentValues.put("loginPersonne",loginPersonne);
        return contentValues;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    public int getAgePersonne() {
        return agePersonne;
    }

    public void setAgePersonne(int agePersonne) {
        this.agePersonne = agePersonne;
    }

    public int getPoidsPersonne() {
        return poidsPersonne;
    }

    public void setPoidsPersonne(int poidsPersonne) {
        this.poidsPersonne = poidsPersonne;
    }

    public Date getDateMajPersonne() {
        return dateMajPersonne;
    }

    public void setDateMajPersonne(Date dateMajPersonne) {
        this.dateMajPersonne = dateMajPersonne;
    }

    public String getLoginPersonne() {
        return loginPersonne;
    }

    public void setLoginPersonne(String loginPersonne) {
        this.loginPersonne = loginPersonne;
    }
}
