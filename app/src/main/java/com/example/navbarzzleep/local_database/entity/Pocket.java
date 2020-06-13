package com.example.navbarzzleep.local_database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pocket_table")
public class Pocket {


    @PrimaryKey(autoGenerate = true)
     private int id;

     private String text;

    public Pocket(String text)
    {
        this.text = text;

    }

    public String getText() {return text;}

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }
}
