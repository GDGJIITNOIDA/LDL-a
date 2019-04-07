package com.example.fd.ldl.Fragments_and_BottomSheets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fd.ldl.BottomSheetCollege;
import com.example.fd.ldl.BottomSheetDay;
import com.example.fd.ldl.BottomSheetRole;
import com.example.fd.ldl.BottomSheetTeam;
import com.example.fd.ldl.R;

public class AddMember extends Fragment {
    View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.fragment_add_member,container,false);

        Button bsTeam = rootView.findViewById(R.id.btn_team);
        Button bsCollege=rootView.findViewById(R.id.btn_colg);
        Button bsRole=rootView.findViewById(R.id.btn_role);
        Button bsDay= rootView.findViewById(R.id.btn_day);

        bsTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetTeam bsTeam= new BottomSheetTeam();
                bsTeam.show(((AppCompatActivity)getActivity()).getSupportFragmentManager(), "bsTeam");
            }
        });


        bsCollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetCollege bsCollege= new BottomSheetCollege();
                bsCollege.show(((AppCompatActivity)getActivity()).getSupportFragmentManager(), "bsCollege");
            }
        });


        bsRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetRole bsRole= new BottomSheetRole();
                bsRole.show(((AppCompatActivity)getActivity()).getSupportFragmentManager(), "bsRole");
            }
        });


        bsDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDay bsDay= new BottomSheetDay();
                bsDay.show(((AppCompatActivity)getActivity()).getSupportFragmentManager(), "bsDay");
            }
        });
        return rootView ;

    }
    }

