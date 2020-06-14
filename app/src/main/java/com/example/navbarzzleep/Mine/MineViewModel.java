package com.example.navbarzzleep.Mine;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.navbarzzleep.pokemonProfil.ProfileRepository;

public class MineViewModel extends ViewModel {
    private ProfileRepository profileRepository;

    public MineViewModel() {
        profileRepository = ProfileRepository.getInstance();
    }

    public void mining(int money)
    {
        profileRepository.mining(money);
    }

    public LiveData<Integer> getMoney()
    {
        return profileRepository.getMoney();
    }
}
