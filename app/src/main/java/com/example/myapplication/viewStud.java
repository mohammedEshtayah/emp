package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class viewStud  extends RecyclerView.Adapter< viewStud.ViewHolder > {
    private List<list> list;
    private Context context;
    private Cursor cursor;


    public  viewStud(List<list> list , Context context){

        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.view,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewStud.ViewHolder holder, int position) {

        list lists=list.get(position);
         holder.ID.setText(Integer.toString(lists.ID()));
        holder.age.setText(Integer.toString(lists.age()));
        holder.name.setText(lists.getName() );



    }


    @Override
    public int getItemCount() {
        return list.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView ID,name,age;




        private boolean pregnant;
        public ViewHolder(View itemView) {
            super(itemView);

            ID=(TextView)itemView.findViewById(R.id.id);
            name=(TextView)itemView.findViewById(R.id.names);
            age=(TextView)itemView.findViewById(R.id.age);




               }
    }
}