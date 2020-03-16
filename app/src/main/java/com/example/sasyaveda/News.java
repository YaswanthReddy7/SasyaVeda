package com.example.sasyaveda;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class News extends Fragment {

    CropModel value;

    public News() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_news,container,false);

        final RecyclerView rv=view.findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        value=new CropModel();
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        ref.child("record").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                List<CropModel> cropModelList=new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    value = ds.getValue(CropModel.class);
                    cropModelList.add(value);
                }
                //Toast.makeText(News.this, "" + c.size(), Toast.LENGTH_SHORT).show();
                CropAdapter my=new CropAdapter(getActivity(),cropModelList);
                rv.setAdapter(my);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }


}
