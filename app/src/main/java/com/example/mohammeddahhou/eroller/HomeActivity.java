package com.example.mohammeddahhou.eroller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import fragment.AutonomieFragment;
import fragment.BlueToothFragment;
import fragment.CardFragment;
import fragment.ConfigurationFragment;
import fragment.HistoryFragment;

public class HomeActivity extends AppCompatActivity {

    private Fragment fragment;
    private ActionBar actionBar;
    private FragmentManager fragmentManager;
    private Menu menu;
    private BottomBar bottombar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return selectFragment(R.id.configuration);
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        actionBar=getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        bottombar = (BottomBar) findViewById(R.id.bottomBar);
        bottombar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
               selectFragment(tabId);
            }
        });
        selectFragment(R.id.navigation_map);

    }




    private boolean selectFragment(int id) {
        switch (id) {
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
                fragment = new AutonomieFragment();
                break;
            case R.id.bluetooth:
                fragment = new BlueToothFragment();
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
