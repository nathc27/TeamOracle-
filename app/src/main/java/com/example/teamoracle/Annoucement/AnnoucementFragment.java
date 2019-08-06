package com.example.teamoracle.Annoucement;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamoracle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import dmax.dialog.SpotsDialog;

public class AnnoucementFragment extends Fragment {
    Context context;
    private FirebaseDatabase annoucementDatabase;
    FirebaseLoadListener firebaseLoadListener;
    RecyclerView verticalRVParent;
    DatabaseReference annoucementData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_annoucement, container, false);
        FirebaseApp annoucementApp = FirebaseApp.getInstance("Annoucement");
        FirebaseDatabase annoucementDatabase = FirebaseDatabase.getInstance(annoucementApp);

        annoucementData = annoucementDatabase.getReference("AnnoucementData");
        //firebaseLoadListener = this;
        verticalRVParent = rootView.findViewById(R.id.verticalRVParent);
        verticalRVParent.setLayoutManager(new LinearLayoutManager(getContext()));
        getCardData();
        return rootView;
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

