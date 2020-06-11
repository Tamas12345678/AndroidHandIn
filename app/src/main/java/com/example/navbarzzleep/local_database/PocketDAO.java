package com.example.navbarzzleep.local_database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.navbarzzleep.local_database.entity.Pocket;

import java.util.List;

@Dao
public interface PocketDAO {

    @Insert
    void addText(Pocket pocket);


    @Query("SELECT * FROM Pocket_table")
    List<Pocket> getAllText();

    @Query("DELETE FROM Pocket_table")
    void deleteAllText();

    @Query("DELETE FROM Pocket_table WHERE text = :text")
    void deleteSpecificEl(String text);

}
