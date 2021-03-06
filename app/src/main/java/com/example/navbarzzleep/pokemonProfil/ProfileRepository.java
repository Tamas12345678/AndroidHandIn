package com.example.navbarzzleep.pokemonProfil;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.navbarzzleep.network.Pokemon;
import com.example.navbarzzleep.network.PokemonAPI;
import com.example.navbarzzleep.network.PokemonPlaceHolder;
import com.example.navbarzzleep.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {

    private static ProfileRepository repository;
    private MutableLiveData<Pokemon> pokemon;
    private MutableLiveData<Integer> money;



    private int testingGold;

    private ProfileRepository()
    {
        pokemon = new MutableLiveData<>();
        money = new MutableLiveData<>();
    }

    public static synchronized ProfileRepository getInstance() {
        if (repository== null) {
            repository= new ProfileRepository();
        }
        return repository;
    }

    public LiveData<Pokemon> getPokemon() {
        return pokemon;
    }

    public void updateProfilePicture(String pokemonName)
    {
        Log.i("FLOW", "REPOSITORY");
        PokemonAPI pokemonAPI = ServiceGenerator.getPokemonAPI();
        Call<PokemonPlaceHolder> call = pokemonAPI.getPokemon(pokemonName);
        call.enqueue(new Callback<PokemonPlaceHolder>() {
            @Override
            public void onResponse(Call<PokemonPlaceHolder> call, Response<PokemonPlaceHolder> response) {
                if(response.code() == 200)
                {
                    pokemon.setValue(response.body().getPokemon());
                }else{
                    Log.i("ERROR", "We have received the following error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<PokemonPlaceHolder> call, Throwable t) {
                Log.i("ERROR","Something has to be fixed");
            }
        });
    }
    public void mining(int received) {
        money.setValue(received);
    }

    public LiveData<Integer> getMoney() {
        return money;
    }

    public int getTestingGold() {
        return testingGold;
    }

    public void setTestingGold(int testingGold) {
        this.testingGold = testingGold;
    }
}