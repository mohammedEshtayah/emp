package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class delete extends AppCompatActivity {
    private EditText id;
    private Button delete;

    public SQLiteDatabase db;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        id=(EditText)findViewById(R.id.id);
        delete=(Button)findViewById(R.id.delete);
        db=   getApplicationContext().openOrCreateDatabase( "DBB.db" ,MODE_PRIVATE,null);
        db.execSQL("   create table IF NOT EXISTS stud(ID number, name char,age number  );");
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int   idd=Integer.parseInt(id.getText().toString());
              db.execSQL("delete from stud where id="+idd+"");

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
