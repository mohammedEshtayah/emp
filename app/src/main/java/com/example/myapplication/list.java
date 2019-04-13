package com.example.myapplication;


public class list {
    private int ID,age;
    private String name ;




    public list(int ID ,String name ,int age){
        this.ID=ID;
        this.name=name;
        this.age=age;


    }

    public int ID(){            return ID;        }
    public String getName(){            return name;        }
    public int age(){            return age;        }


}