package com.bbx.androidexam;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bbx.androidexam.common.InternalStorage;
import com.bbx.androidexam.fragments.PersonListFragment;
import com.bbx.androidexam.models.PersonList;

public class MainActivity extends AppCompatActivity{

    InternalStorage internalStorage;
    PersonList personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder, new PersonListFragment());
        ft.commit();
    }


}
