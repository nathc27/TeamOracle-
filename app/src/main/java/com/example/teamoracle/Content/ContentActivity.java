package com.example.teamoracle.Content;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.teamoracle.Annoucement.AnnoucementFragment;
import com.example.teamoracle.Learn.LearnFragment;
import com.example.teamoracle.R;
import com.example.teamoracle.profile.ProfileFragment;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch(menuItem.getItemId()) {
                    case R.id.navigation_annoucement:
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
        });
        navigation.setSelectedItemId(R.id.navigation_learn);

        loadFragment(new ContentFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

}
