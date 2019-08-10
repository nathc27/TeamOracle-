package com.example.teamoracle.Quiz;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.teamoracle.Annoucement.AnnoucementFragment;
import com.example.teamoracle.DashboardActivity;
import com.example.teamoracle.Learn.LearnFragment;
import com.example.teamoracle.R;
import com.example.teamoracle.profile.ProfileFragment;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

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


       FirebaseOptions optionsQuiz = new FirebaseOptions.Builder()
                .setApplicationId("1:185031561701:android:8c9b9bfc66f08c97")
                .setApiKey("AIzaSyDUfBS0BTLfwPIt7ASDzBiVk2idJixaokY")
                .setDatabaseUrl("https://quizdata-454fd.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(this, optionsQuiz, "Topics");

        // Loads the selected fragment
        loadFragment(new QuizFragment());
    }
        private boolean loadFragment(Fragment fragment) {
            if(fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
            return false;
        }

    }