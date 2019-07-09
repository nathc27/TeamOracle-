package com.example.teamoracle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch(item.getItemId()) {
            case R.id.navigation_hub:
                fragment = new AnnoucementFragment();
                break;
            case R.id.navigation_learn:
                fragment = new LearnFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
    }
}
