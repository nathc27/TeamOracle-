package com.example.teamoracle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.teamoracle.profile.ProfileFragment;
import com.example.teamoracle.Learn.LearnFragment;
import com.example.teamoracle.Annoucement.AnnoucementFragment;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import static com.example.teamoracle.R.id.navigation_learn;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        boolean finish = getIntent().getBooleanExtra("finish", false);
        if (finish) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        // Sets the Learn tab as the default tab
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setSelectedItemId(R.id.navigation_learn);

        // Loads the selected fragment
        loadFragment(new LearnFragment());

        // Connects the Learn database
        FirebaseOptions optionsLearn = new FirebaseOptions.Builder()
                .setApplicationId("1:62125859406:android:c7b3867e4f759f5e")
                .setApiKey("AIzaSyB5gBPq8CySbeSSkEJd1Vrb3_cPDxvL40A")
                .setDatabaseUrl("https://rvpop-a60e9.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(this, optionsLearn, "Learn");
    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

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
    }
