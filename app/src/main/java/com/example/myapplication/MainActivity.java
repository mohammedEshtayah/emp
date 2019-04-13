package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
     private Button add,delete,update;
    private List<list> listview= new ArrayList<>();
    private list listOne;
    private viewStud viewStud;
    private Cursor cursor;
    public SQLiteDatabase db;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add=(Button)findViewById(R.id.add);
        delete=(Button)findViewById(R.id.delete);
        update=(Button)findViewById(R.id.update);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db=   getApplicationContext().openOrCreateDatabase( "DBB.db" ,MODE_PRIVATE,null);
        db.execSQL("   create table IF NOT EXISTS stud(ID number, name char,age number  );");

        cursor=db.rawQuery("select * from stud",null);
        while (cursor.moveToNext()) {
            listOne = new list(
                    cursor.getInt(cursor.getColumnIndex("ID")),
                    cursor.getString(cursor.getColumnIndex("name"))  ,
                    cursor.getInt(cursor.getColumnIndex("age")));
            listview.add(listOne);

        }
        viewStud = new viewStud(listview, getApplicationContext());
        recyclerView.setAdapter(viewStud);



        add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext(),add.class));

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext(),uodate.class));

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                startActivity(new Intent( getApplicationContext(),delete.class));

            }
        });
    }
}
