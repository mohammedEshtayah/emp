package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class add extends AppCompatActivity {
private EditText id,name,age;
private Button add;

    public SQLiteDatabase db;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        id=(EditText)findViewById(R.id.id);
        age=(EditText)findViewById(R.id.age);
        name=(EditText)findViewById(R.id.name);
        db=   getApplicationContext().openOrCreateDatabase( "DBB.db" ,MODE_PRIVATE,null);
        db.execSQL("   create table IF NOT EXISTS stud(ID number, name char,age number  );");
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int idd=Integer.parseInt(id.getText().toString());
                final int agee=Integer.parseInt(age.getText().toString());
              db.execSQL("insert into stud values( "+idd+",'"+name.getText().toString()+"' ,"+agee+")");
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent( getApplicationContext(),MainActivity.class));
        finish();

    }
}
