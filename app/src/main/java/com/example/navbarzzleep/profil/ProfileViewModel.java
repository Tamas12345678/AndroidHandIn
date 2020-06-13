package com.example.navbarzzleep.profil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.navbarzzleep.network.Pokemon;

public class ProfileViewModel extends ViewModel {

    ProfileRepository repository;

    public ProfileViewModel(ProfileRepository repository) {
        this.repository = repository;
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
