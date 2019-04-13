package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class uodate extends AppCompatActivity {
    private EditText  age,id;
    private Button update;

    public SQLiteDatabase db;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uodate);
        age=(EditText)findViewById(R.id.age);
        id=(EditText)findViewById(R.id.idd);
        update=(Button)findViewById(R.id.update);
        db=   getApplicationContext().openOrCreateDatabase( "DBB.db" ,MODE_PRIVATE,null);
        db.execSQL("   create table IF NOT EXISTS stud(ID number, name char,age number  );");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              final int idd=Integer.parseInt(id.getText().toString());
                final int  agee=Integer.parseInt(age.getText().toString());
          db.execSQL("update stud set age="+agee+"  where id="+idd+"");

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
