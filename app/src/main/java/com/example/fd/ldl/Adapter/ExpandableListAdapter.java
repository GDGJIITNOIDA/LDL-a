package com.example.fd.ldl.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fd.ldl.Model.ExpandedMenuModel;
import com.example.fd.ldl.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<ExpandedMenuModel> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<ExpandedMenuModel, List<String>> _listDataChild;
    ExpandableListView expandList;

    public ExpandableListAdapter(Context _context, List<ExpandedMenuModel> _listDataHeader, HashMap<ExpandedMenuModel, List<String>> _listDataChild, ExpandableListView mView) {
        this._context = _context;
        this._listDataHeader = _listDataHeader;
        this._listDataChild = _listDataChild;
        this.expandList=mView;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
            }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ExpandedMenuModel headerTitle = (ExpandedMenuModel) getGroup(groupPosition);
                if (convertView == null) {
                    LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = infalInflater.inflate(R.layout.list_group_header, null);
                }

                TextView expandableListHeader = (TextView) convertView.findViewById(R.id.expandableListHeader);
               // ImageView headerIcon = (ImageView) convertView.findViewById(R.id.icon_image);
                expandableListHeader.setTypeface(null, Typeface.BOLD);
                expandableListHeader.setText(headerTitle.getIconName());
               // headerIcon.setImageResource(headerTitle.getIconImg());
                return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_child, null);
        }
            
            TextView txtListChild = (TextView) convertView.findViewById(R.id.expandableListItem);
            txtListChild.setText(childText);
             return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
