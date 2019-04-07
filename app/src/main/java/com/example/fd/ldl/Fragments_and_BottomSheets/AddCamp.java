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
import android.widget.TextView;

import com.example.fd.ldl.BottomSheetCity;
import com.example.fd.ldl.R;

public class AddCamp extends Fragment implements BottomSheetCity.BottomSheetListener {
    private TextView tvCity;
    Button btnCity , btnSave ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_add_camp, container, false);

       // btnCity = rootView.findViewById(R.id.btnCity);
        btnSave = rootView.findViewById(R.id.btnSave);
        tvCity = rootView.findViewById(R.id.tvCity);
      /*  btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetCity bottomsheet = new BottomSheetCity();
                bottomsheet.show(((AppCompatActivity)getActivity()).getSupportFragmentManager(),"bottomSheetCity");

            }
        });*/

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return  rootView;
    }

    @Override
    public void onButtonClicked(String text) {
        tvCity.setText(text);
    }
}
