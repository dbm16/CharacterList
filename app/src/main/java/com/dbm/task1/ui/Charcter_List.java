package com.dbm.task1.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dbm.task1.R;

public class Charcter_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charcter_list);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, Character_List_Fragment.newInstance())
                    .commit();
        }
    }
}
