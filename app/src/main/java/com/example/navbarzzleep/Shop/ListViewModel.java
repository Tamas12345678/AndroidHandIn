package com.example.navbarzzleep.Shop;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.navbarzzleep.local_database.entity.Pocket;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListViewModel extends AndroidViewModel {

    private ListRepository repository;

    public ListViewModel(@NonNull Application application) {
        super(application);
        repository = ListRepository.getInstance(application);
    }

    public void addToList() {repository.addToList();}

    public List<Pocket> getAllText() throws ExecutionException, InterruptedException {return repository.getAllText();}

    public  void deleteAll() {repository.deleteAll();}

}
