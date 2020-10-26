package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] countryNames;
    private TextView textView1;
    private Button button1;
    private Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryNames=getResources().getStringArray(R.array.Country);
        textView1=findViewById(R.id.text1);
        button1=findViewById(R.id.button1);
        spinner1=findViewById(R.id.spin1);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.sample1,R.id.textshow1,countryNames);
        spinner1.setAdapter(adapter1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1=spinner1.getSelectedItem().toString();
                textView1.setText(val1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item1)
        {
            Toast.makeText(MainActivity.this,"Item1",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId()==R.id.item2)
        {
            Toast.makeText(MainActivity.this,"Item2",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            Toast.makeText(MainActivity.this,"Item3",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
