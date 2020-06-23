package com.example.myclockdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Analyzer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextClock tx1;
    private AnalogClock anc1;
    private Button bn1;
    private AlertDialog.Builder alertbuilder;
    private AlertDialog ad1;
    public void buttonShow(View view)
    {

            alertbuilder=new AlertDialog.Builder(MainActivity.this);
            alertbuilder.setTitle("Alert");
            alertbuilder.setMessage("Wanna get a fuck?");
            alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"Fuck me",Toast.LENGTH_SHORT).show();
                    //finish();
                }
            });
            alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"Bang my pussy,Dear",Toast.LENGTH_SHORT).show();
                }
            });
            ad1=alertbuilder.create();
            ad1.show();
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anc1=findViewById(R.id.an1);
        tx1=findViewById(R.id.txc1);
        bn1=findViewById(R.id.bn2);
        anc1.setOnClickListener(this);
        tx1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.an1)
        {
            Toast.makeText(MainActivity.this,"Analogue Clock",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Text Clock",Toast.LENGTH_SHORT).show();
        }

    }

}
