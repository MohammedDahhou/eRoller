package com.example.mohammeddahhou.eroller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import fragment.CardFragment;
import fragment.ConfigurationFragment;
import fragment.HistoryFragment;

public class ClientActivity extends AppCompatActivity {

    private Fragment fragment;
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private Menu menu;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return selectFragment(item);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        navigation = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        menu = navigation.getMenu();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        selectFragment(menu.getItem(0));
        navigation.setSelectedItemId(R.id.configuration);


    }


    private boolean selectFragment(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_map:
                fragment = new CardFragment();
                break;
            case R.id.history:
                fragment = new HistoryFragment();
                break;
            case R.id.configuration:
                fragment = new ConfigurationFragment();
                break;
            case R.id.Autonomie:
                fragment = new ConfigurationFragment();
                break;
            case R.id.bluetooth:
                fragment = new ConfigurationFragment();
                break;
        }
        fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.main_activity_fragment, fragment);
                ft.commit();
            }
        }
        return false;
    }


}
