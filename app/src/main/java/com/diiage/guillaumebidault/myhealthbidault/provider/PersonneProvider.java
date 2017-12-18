package com.diiage.guillaumebidault.myhealthbidault.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.diiage.guillaumebidault.myhealthbidault.beans.Personne;
import com.diiage.guillaumebidault.myhealthbidault.dao.PersonneDao;

import java.util.List;

/**
 * Created by GuillaumeBidault on 17/11/2017.
 */

public class PersonneProvider extends ContentProvider{

    public static final String AUTHORITY = "fr.diiage.bidault.myhealth.PersonneProvider";

    private static final int DIR = 0;
    private static final int ITEM = 1;
    private static final int CHAMP = 2;
    private static final int FIND = 3;

    private static final UriMatcher membreMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        membreMatcher.addURI(AUTHORITY, "personne", DIR);
        membreMatcher.addURI(AUTHORITY, "personne/#", ITEM);
        membreMatcher.addURI(AUTHORITY, "personne/#/*", CHAMP);
        membreMatcher.addURI(AUTHORITY, "personne/find/*", FIND);
    }

    public static final Uri CONTENT_URI =Uri.parse("content://" + AUTHORITY + "/personne");

    // Types MIME
    public static final String TYPE_DIR ="vnd.android.cursor.dir/vnd." + AUTHORITY + ".personne";
    public static final String TYPE_ITEM ="vnd.android.cursor.item/vnd." + AUTHORITY + ".personne";

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        switch(membreMatcher.match(uri)){
            case DIR:
                PersonneDao personneDao=new PersonneDao(this.getContext());
                personneDao.open();
                Cursor cursor=personneDao.getPersonnesCursor();
                //personneDao.close();
                return cursor;
            case ITEM:

                break;
            default:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
