package com.example.navbarzzleep.local_database;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.navbarzzleep.local_database.entity.Pocket;

@Database(entities = {Pocket.class}, version = 8)
public abstract class LocalDatabase extends RoomDatabase {

    private static LocalDatabase instance;
    public abstract PocketDAO pocketDAO();

    public static synchronized LocalDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalDatabase.class,"local_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private PocketDAO pocketDAO;
        private PopulateDbAsyncTask(LocalDatabase db)
        {
            pocketDAO = db.pocketDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            pocketDAO.addText(new Pocket("Text"));
            return null;
        }
    }

}
