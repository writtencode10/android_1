package com.example.expandablelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView1;
    private int lastExpandablePosition=-1;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    private CustomAdapter customAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepare();
        expandableListView1=findViewById(R.id.expl1);
        customAdapter1=new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView1.setAdapter(customAdapter1);
        expandableListView1.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String groupName=listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView1.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),"groupName is collapsed",Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView1.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childString=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        expandableListView1.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandablePosition!=-1 && lastExpandablePosition!=groupPosition)
                {
                    expandableListView1.collapseGroup(lastExpandablePosition);
                }
                lastExpandablePosition=groupPosition;
            }
        });


    }
    public void prepare()
    {
        String[] headerString=getResources().getStringArray(R.array.Country);
        String[] childString=getResources().getStringArray(R.array.Countrydetaails);
        listDataHeader=new ArrayList<>();
        listDataChild=new HashMap<>();
        for (int i=0;i<headerString.length;i++)
        {
            listDataHeader.add(headerString[i]);
            List<String> child=new ArrayList<>();
            child.add(childString[i]);
            listDataChild.put(listDataHeader.get(i),child);


        }
    }
}
