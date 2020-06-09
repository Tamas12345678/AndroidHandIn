package com.example.navbarzzleep.local_database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pocket_table")
public class Pocket {

    @PrimaryKey(autoGenerate = true)
    private int primaryKey;
    private int gold;

    public Pocket(int gold)
    {
        this.gold = gold;
    }

    public int getGold() {return gold;}

}
