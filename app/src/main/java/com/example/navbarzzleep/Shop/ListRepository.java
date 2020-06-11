package com.example.navbarzzleep.Shop;

import android.app.Application;
import android.os.AsyncTask;

import com.example.navbarzzleep.local_database.LocalDatabase;
import com.example.navbarzzleep.local_database.PocketDAO;
import com.example.navbarzzleep.local_database.entity.Pocket;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListRepository {

    private PocketDAO pocketDAO;

    private static ListRepository repository;

    private ListRepository(Application application)
    {
        LocalDatabase database = LocalDatabase.getInstance(application);
        pocketDAO= database.pocketDAO();
    }

    public static synchronized ListRepository getInstance(Application application) {
        if (repository== null) {
            repository= new ListRepository(application);
        }
        return repository;
    }


    public List<Pocket> getAllText() throws ExecutionException, InterruptedException {
        return new getDataAsync(pocketDAO).execute().get();
    }



    private static class getDataAsync extends AsyncTask<Void,Void, List<Pocket>>
    {
        private PocketDAO pocketDAO;

        private getDataAsync(PocketDAO pocketDAO){
            this.pocketDAO=pocketDAO;
        }

        @Override
        protected List<Pocket> doInBackground(Void... voids) {
            return pocketDAO.getAllText();
        }
    }



    public void addToList() {
       new InsertAsync(pocketDAO).execute();
    }

    private static class InsertAsync extends AsyncTask<String, Void, Void>
    {
        private PocketDAO pocketDAO;

        private InsertAsync(PocketDAO pocketDAO){
            this.pocketDAO=pocketDAO;
        }


        @Override
        protected Void doInBackground(String... strings) {
            Pocket pocket = new Pocket(strings[0]);
             pocketDAO.addText(pocket);

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
