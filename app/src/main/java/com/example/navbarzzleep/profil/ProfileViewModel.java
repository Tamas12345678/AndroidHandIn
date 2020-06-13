package com.example.navbarzzleep.profil;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.navbarzzleep.network.Pokemon;

public class ProfileViewModel extends AndroidViewModel {

    private ProfileRepository repository;
    private MutableLiveData<Pokemon> pokemon;

    public ProfileViewModel(Application application)
    {
        super(application);
       pokemon = new MutableLiveData<>();
        repository = ProfileRepository.getInstance(application);
    }

    LiveData<Pokemon> getPokemon()
    {
        return repository.getPokemon();
    }

    public void updateProfilePicture(String text)
    {
        repository.updateProfilePicture(text);
    }

}
