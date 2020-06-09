package com.example.navbarzzleep.Mine;

import android.app.Application;
import android.os.AsyncTask;

import com.example.navbarzzleep.local_database.LocalDatabase;
import com.example.navbarzzleep.local_database.PocketDAO;
import com.example.navbarzzleep.local_database.entity.Pocket;

public class Mine_Repository {

    private PocketDAO pocketDAO;

    private static Mine_Repository instance;


    //Access to database
    private Mine_Repository(Application application)
    {
        LocalDatabase database = LocalDatabase.getInstance(application);
        pocketDAO = database.pocketDAO();
    }

    //create an instance of repository
    public static synchronized Mine_Repository getInstance(Application application)
    {
        if(instance == null)
        {
            instance = new Mine_Repository(application);
        }
        return instance;
    }

   public void addGold(Pocket pocket){
    new InsertContactAsync(pocketDAO).execute(pocket);
   }

public static class InsertContactAsync extends AsyncTask<Pocket, Void, Void> {
        private PocketDAO pocketDAO;

        private InsertContactAsync(PocketDAO pocketDAO) {
            this.pocketDAO = pocketDAO;
        }

    @Override
    protected Void doInBackground(Pocket... pockets) {
            pocketDAO.addGold(pockets[0]);

        return null;
    }
}



}
