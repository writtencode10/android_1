package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    private TextView t1;
    private EditText tx1,tx2;
    private String text1,text2;
    private CheckBox cb1,cb2,cb3;
    private Button bgc1;
    private StringBuilder sbuilder;
    double num1,num2;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.tex1);
        tx1=findViewById(R.id.Text1);
        tx2=findViewById(R.id.Text2);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);
        bgc1=findViewById(R.id.buttongc1);
        sbuilder=new StringBuilder();
        bgc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked())
                {
                    sbuilder.append(cb1.getText().toString()+"is Checked");
                }
                else if(cb2.isChecked())
                {
                    sbuilder.append(cb2.getText().toString()+"is Checked");
                }
                else
                {
                    sbuilder.append(cb3.getText().toString()+"is Checked");
                }
                t1.setText(sbuilder);
            }
        });
    }

   public void showMessage(View v)
   {
       try {
           if(v.getId()==R.id.img)
           {
               count++;
               t1.setText("Clicked "+count);
               LayoutInflater lf=getLayoutInflater();



               View cv=lf.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.tst));
               Toast toast1=new Toast(MainActivity.this);
               toast1.setDuration(Toast.LENGTH_SHORT);
               toast1.setGravity(Gravity.CENTER,0,0);
               toast1.setView(cv);
               toast1.show();
           }
           else if(v.getId()==R.id.but1)
           {
               text1=tx1.getText().toString();
               text2=tx2.getText().toString();
               num1=Double.parseDouble(text1);
               num2=Double.parseDouble(text2);
               double sum=num1+num2;
               t1.setText("Sum is "+sum);
               Log.d("tag1","Sum");
           }

       }catch (Exception e)
       {
           t1.setText("Please input num");
       }


   }
}
