package com.example.hp.slideactivity;

/**
 * Created by HP on 11/25/2016.
 */

public class Schemadb {
    String Breakfast;
    String Lunch;
    String Dinner;
    int id;


    public Schemadb(int i,String s1,String s2,String s3){
        Breakfast=s1;
        Lunch=s2;
        Dinner=s3;
        id=i;

    }

    public int getId() {
        return id;
    }

    public String getBreakfast() {
        return Breakfast;
    }

    public String getDinner() {
        return Dinner;
    }

    public String getLunch() {
        return Lunch;
    }

    public void setBreakfast(String breakfast) {
        Breakfast = breakfast;
    }

    public void setDinner(String dinner) {
        Dinner = dinner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLunch(String lunch) {
        Lunch = lunch;
    }
}
