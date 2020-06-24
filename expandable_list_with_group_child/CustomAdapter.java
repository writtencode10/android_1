package com.example.expandablelist;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import static com.example.expandablelist.R.layout.group_layout;

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context context1;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    public CustomAdapter(Context context1, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this.context1 = context1;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listDataChild.get(listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
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
        String headerText= (String) getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.group_layout,null);

        }
        TextView textView1=convertView.findViewById(R.id.text1);
        textView1.setText(headerText);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText= (String) getChild(groupPosition,childPosition);
        if(convertView==null)
        {
            LayoutInflater inflater= (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.child_layout,null);

        }
        TextView textView1=convertView.findViewById(R.id.textchild1);
        textView1.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
