package com.example.teamoracle.Annoucement;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teamoracle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;


public class AnnoucementFragment extends Fragment {
    View annoucementsFragment;
    AlertDialog dialog;
    RecyclerView listAnnoucement;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference annoucement;
    RecyclerView rvAnnoucement;
    private List<Annoucement> annoucementList;

    public static AnnoucementFragment newInstance(){
        AnnoucementFragment annoucementFragment = new AnnoucementFragment();
        return annoucementFragment;
    }
    public AnnoucementFragment (){}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_announcement2, container, false);

        //RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rvAnnoucement);

      //  recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       // RecyclerView.Adapter mAdapter = new AnnoucementAdapter(this, Annoucements.getDummyAnnoucements());
        //recyclerView.setAdapter(mAdapter);


        return rootView;



    }
}