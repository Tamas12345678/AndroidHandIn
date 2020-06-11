package com.example.navbarzzleep.local_database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pocket_table")
public class Pocket {

    @PrimaryKey(autoGenerate = true)
    String text;

    public Pocket(String text)
    {
        this.text = text;

    }

    public String getText() {return text;}


}
