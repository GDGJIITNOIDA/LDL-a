package com.example.fd.ldl.Fragments_and_BottomSheets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fd.ldl.R;

public class AddCity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_add_city, container, false);
        EditText etName, etCity;
        Button btnSaveCity;

        etName = rootView.findViewById(R.id.etName);
        etCity = rootView.findViewById(R.id.etCity);
        btnSaveCity =rootView.findViewById(R.id.btnSaveCity);

        btnSaveCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return rootView;
    }
}
