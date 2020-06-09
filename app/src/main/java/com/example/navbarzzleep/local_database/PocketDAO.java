package com.example.navbarzzleep.local_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.navbarzzleep.local_database.entity.Pocket;

@Dao
public interface PocketDAO {

    @Insert
    void addGold(Pocket pocket);


    @Query("SELECT gold FROM Pocket_table")
    LiveData<Pocket> getLatestGold();

    @Query("UPDATE Pocket_table SET gold = 12")
    void insert(Pocket pocket);
}
