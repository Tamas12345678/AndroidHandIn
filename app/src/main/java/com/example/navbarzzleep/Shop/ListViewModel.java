package com.example.navbarzzleep.Shop;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.navbarzzleep.local_database.entity.Pocket;

import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private ListRepository repository;

    public ListViewModel(@NonNull Application application) {
        super(application);
        repository = ListRepository.getInstance(application);
    }

    public void addToList(Pocket pocket) {
        Log.i("TAG" , "haha");
        repository.addToList(pocket);}

    public LiveData<List<Pocket>> getAllText() {return repository.getAllTexts();}

    public  void deleteAll() {repository.deleteAll();}

}
