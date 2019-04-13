package com.example.fd.ldl.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.fd.ldl.LDLService;
import com.example.fd.ldl.Model.City;
import com.example.fd.ldl.R;
import com.example.fd.ldl.utils.retrofit.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCollegeFragment extends Fragment {
    Context context;
    EditText etCollegeName,etAddress,etCity;
    ImageView imgViewEdit;
    ArrayAdapter list_adapter;
    String[] cityname;
    BottomSheetDialog dialog;

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_add_college, container, false);
        etCollegeName = rootView.findViewById(R.id.etCollegeName);
        etAddress = rootView.findViewById(R.id.etAddress);
        etCity =rootView.findViewById(R.id.etCity);
        imgViewEdit=rootView.findViewById(R.id.imgViewEditCity);
        etCity.setInputType(InputType.TYPE_NULL);

        fetch_city();

       imgViewEdit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              loadBottomSheetCity();
               dialog.show();
           }
       });
        return rootView;
    }

    private void fetch_city(){
        LDLService api = ApiClient.getApi().create(LDLService.class);
        Call<ArrayList<City>> call = api.getCity();
        call.enqueue(new Callback<ArrayList<City>>() {
            @Override
            public void onResponse(Call<ArrayList<City>> call, Response<ArrayList<City>> response) {
                ArrayList<City> r = response.body();
                Log.i("dsf","get_city: "+r);
                cityname=new String[r.size()];

                for(int i=0;i<r.size();i++){
                    cityname[i]=r.get(i).getName();
                    Log.i("dsf","get_city: "+cityname[i]);
                }
                list_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, cityname);
            }
            @Override
            public void onFailure(Call<ArrayList<City>> call, Throwable t) {
                Log.i("dsf","get_city error: "+t);

            }
        });
    }

    private void loadBottomSheetCity(){
        final View modelBottomSheet = LayoutInflater.from(getActivity()).inflate(R.layout.bottom_sheet_city, null);
        dialog = new BottomSheetDialog(getActivity());
        dialog.setContentView(modelBottomSheet);
        final BottomSheetBehavior mBehavior = BottomSheetBehavior.from((View) modelBottomSheet.getParent());
        mBehavior.setHideable(false);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                mBehavior.setPeekHeight(modelBottomSheet.getHeight());
            }
        });
        ListView cityListView= dialog.findViewById(R.id.city_listView);
        cityListView.setAdapter(list_adapter);
        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected_city=cityname[i];
                etCity.setText(selected_city);
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

}
