package com.example.navbarzzleep.pokemonProfil;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.navbarzzleep.network.Pokemon;

public class ProfileViewModel extends AndroidViewModel {

    private ProfileRepository repository;

    public ProfileViewModel(Application application)
    {
        super(application);
        repository = ProfileRepository.getInstance();
    }

    public LiveData<Pokemon> getPokemon()
    {
        return repository.getPokemon();
    }

    public void updateProfilePicture(String text)
    {
        Log.i("FLOW", "WIEWMODEL");
        repository.updateProfilePicture(text);
    }

    public LiveData<Integer> getMoney()
    {
        return repository.getMoney();
    }

    public void mining(int money)
    {
        repository.mining(money);
    }

}
