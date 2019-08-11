package com.example.teamoracle.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.teamoracle.DashboardActivity;
import com.example.teamoracle.R;
import com.example.teamoracle.Quiz.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    private TextView profileName, profileEmail, level, score, information;
    private Button logOutButton;
    private FirebaseAuth authentication;
    private DatabaseReference databaseReference;
    private FirebaseDatabase db;
    private String userId;
    private int scoreConvert;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        context = rootView.getContext();

        FirebaseApp.initializeApp(this.getContext());
        authentication = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference();
        FirebaseUser user = authentication.getCurrentUser();
        userId = user.getUid();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        profileName = rootView.findViewById(R.id.tv_username);
        profileEmail = rootView.findViewById(R.id.tv_email);
        score = rootView.findViewById(R.id.total);
        level = rootView.findViewById(R.id.tv_position);
        logOutButton = rootView.findViewById(R.id.logOutButton);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        return rootView;
    }

    public void showData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            User user = new User();
            user.setName(ds.child(userId).getValue(User.class).getName());
            user.setEmail(ds.child(userId).getValue(User.class).getEmail());
            user.setTotal(ds.child(userId).getValue(User.class).getTotal());

            profileName.setText(user.getName());
            profileEmail.setText(user.getEmail());
            score.setText(String.valueOf(user.getTotal()));

            final int scoreConvert = Integer.parseInt(String.valueOf(user.getTotal()));
            final String score = String.valueOf(user.getTotal());

            if ((scoreConvert >= 0) && (1000 >= scoreConvert)) {
                level.setText("Novice");
            }
            else if ((scoreConvert >= 1001) && (2000 >= scoreConvert)) {
                level.setText("Adept");
            }
            else if ((scoreConvert >= 2001) && (3000 >= scoreConvert)) {
                level.setText("Expert");
            }
            else {
                level.setText("Master of INFS1609");
            }
        }
    }
    void signOut() {
        Intent intent = new Intent(this.getContext(), DashboardActivity.class);
        intent.putExtra("finish", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
        startActivity(intent);
        getActivity().finish();
    }
}