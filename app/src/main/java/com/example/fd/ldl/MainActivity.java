package com.example.fd.ldl;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.fd.ldl.Adapter.ExpandableListAdapter;
import com.example.fd.ldl.Fragments_and_BottomSheets.AddCamp;
import com.example.fd.ldl.Fragments_and_BottomSheets.AddCity;
import com.example.fd.ldl.Fragments_and_BottomSheets.AddCollege;
import com.example.fd.ldl.Fragments_and_BottomSheets.AddTeam;
import com.example.fd.ldl.Fragments_and_BottomSheets.ViewCamps;
import com.example.fd.ldl.Fragments_and_BottomSheets.ViewCities;
import com.example.fd.ldl.Fragments_and_BottomSheets.ViewColleges;
import com.example.fd.ldl.Fragments_and_BottomSheets.ViewTeam;
import com.example.fd.ldl.Model.ExpandedMenuModel;
import com.example.fd.ldl.Fragments_and_BottomSheets.AddAttendance;
import com.example.fd.ldl.Fragments_and_BottomSheets.AddMember;
import com.example.fd.ldl.Fragments_and_BottomSheets.FetchAttendance;
import com.example.fd.ldl.Fragments_and_BottomSheets.ViewMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    android.app.Fragment fragment = null;
    ExpandableListView expandableListView;
    HashMap<ExpandedMenuModel, List<String>> childList;
    ExpandableListAdapter expandableListAdapter;
    List<ExpandedMenuModel> headerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        //toolbar.setTitle("Lead");
        setSupportActionBar(toolbar);

        expandableListView=findViewById(R.id.expandableListView);
        //expandableListView.setGroupIndicator(null);
        //expandableListView.setChildIndicator(null);
        //expandableListView.setChildDivider(getResources().getDrawable(R.color.transparent));

        prepareMenuData();
        populateExpandableList();

        mDrawerLayout =findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

    }

    @Override
    public void onBackPressed()
    {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void prepareMenuData(){
        headerList = new ArrayList<ExpandedMenuModel>();
        childList = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setIconName("Attendance");
        //item1.setIconImg(R.drawable.ic_leads);
        // Adding data header
        headerList.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setIconName("Members");
        //item2.setIconImg(R.drawable.ic_team);
        headerList.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setIconName("Add New");
        //item3.setIconImg(R.drawable.ic_reimbursement);
        headerList.add(item3);

        ExpandedMenuModel item4 = new ExpandedMenuModel();
        item4.setIconName("View All");
        //item3.setIconImg(R.drawable.ic_reimbursement);
        headerList.add(item4);

        // Adding child data
        List<String> attendace = new ArrayList<String>();
        attendace.add("Add Attendance");
        attendace.add("Fetch Attendance");

        List<String> members = new ArrayList<String>();
        members.add("Add Member");
        members.add("View Members");

        List<String> add_new = new ArrayList<String>();
        add_new.add("Add City");
        add_new.add("Add College");
        add_new.add("Add Camp");
        add_new.add("Add Team");

        List<String> view_all = new ArrayList<String>();
        view_all.add("View City");
        view_all.add("View College");
        view_all.add("View Camp");
        view_all.add("View Team");

        childList.put(headerList.get(0), attendace);// Header, Child data
        childList.put(headerList.get(1), members);
        childList.put(headerList.get(2),add_new);
        childList.put(headerList.get(3),view_all);

    }

    private void populateExpandableList(){
        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList,expandableListView);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                switch (groupPosition) {
                    // lead
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(MainActivity.this, "k", Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddAttendance()).commit();
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "l", Toast.LENGTH_SHORT).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FetchAttendance()).commit();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddMember()).commit();
                                break;
                            case 1:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewMember()).commit();
                                break;

                            default:
                                break;
                        }
                        break;

                    // income slip
                    case 2:
                        switch (childPosition) {

                            case 0:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddCity()).commit();
                                break;
                            case 1:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddCollege()).commit();
                                break;
                            case 2:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddCamp()).commit();
                                break;
                            case 3:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddTeam()).commit();
                                break;
                            default:
                                break;
                        }
                        break;

                    case 3:
                        switch (childPosition) {

                            case 0:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewCities()).commit();
                                break;
                            case 1:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewColleges()).commit();
                                break;
                            case 2:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewCamps()).commit();
                                break;
                            case 3:
                                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewTeam()).commit();
                                break;
                            default:
                                break;
                        }
                        break;

                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

        private void setupDrawerContent(NavigationView navigationView) {
            //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            // menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }

}
