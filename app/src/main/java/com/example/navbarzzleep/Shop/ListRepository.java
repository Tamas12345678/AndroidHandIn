package com.example.navbarzzleep.Shop;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.navbarzzleep.local_database.LocalDatabase;
import com.example.navbarzzleep.local_database.PocketDAO;
import com.example.navbarzzleep.local_database.entity.Pocket;

import java.util.List;

public class ListRepository {

    private PocketDAO pocketDAO;
    private static ListRepository repository;
    private LiveData<List<Pocket>> list;

    private ListRepository(Application application)
    {
        LocalDatabase database = LocalDatabase.getInstance(application);
        pocketDAO= database.pocketDAO();
        list = pocketDAO.getAllText();
    }

    public static synchronized ListRepository getInstance(Application application) {
        if (repository== null) {
            repository= new ListRepository(application);
        }
        return repository;
    }


  public LiveData<List<Pocket>> getAllTexts()
  {
      return list;
  }







    public void addToList(Pocket pocket) {
       new ListRepository.InsertAsync(pocketDAO).execute(pocket);
    }

    private static class InsertAsync extends AsyncTask<Pocket, Void, Void>
    {
        private PocketDAO pocketDAO;

        private InsertAsync(PocketDAO pocketDAO){
            this.pocketDAO=pocketDAO;
        }


        @Override
        protected Void doInBackground(Pocket... pockets) {

             pocketDAO.addText(pockets[0]);

            return null;
        }
    }


    public void deleteAll() {
        new deleteAllAsync(pocketDAO).execute();
    }

    private static class deleteAllAsync extends AsyncTask<Void, Void, Void>
    {
        private PocketDAO pocketDAO;

        private deleteAllAsync(PocketDAO pocketDAO){
            this.pocketDAO=pocketDAO;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            pocketDAO.deleteAllText();
            return null;
        }
    }


}
