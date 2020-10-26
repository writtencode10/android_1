package com.example.view3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;
    private String[] countryArray;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=findViewById(R.id.lst1);
        searchView=findViewById(R.id.searchview1);
        countryArray=getResources().getStringArray(R.array.Country);
        final ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this,R.layout.sample2,R.id.sample2_text1,countryArray);
        listView1.setAdapter(adapter1);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter1.getFilter().filter(newText);
                return false;
            }
        });
    }
    }

