package com.diiage.guillaumebidault.myhealthbidault;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.diiage.guillaumebidault.myhealthbidault.beans.Personne;
import com.diiage.guillaumebidault.myhealthbidault.dao.PersonneDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonneDao personneDao=new PersonneDao(this);
        personneDao.open();
        List<Personne> personnes=personneDao.getPersonnes();
        personneDao.close();
    }
}
