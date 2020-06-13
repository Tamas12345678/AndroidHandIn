package com.example.navbarzzleep.profil;

import android.app.Application;
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

    private ProfileRepository(Application application)
    {
        pokemon = new MutableLiveData<Pokemon>();

    }

    public static synchronized ProfileRepository getInstance(Application application) {
        if (repository== null) {
            repository= new ProfileRepository(application);
        }
        return repository;
    }

    public LiveData<Pokemon> getPokemon() {
        return pokemon;
    }

    public void updateProfilePicture(String pokemonName)
    {
        PokemonAPI pokemonAPI = ServiceGenerator.getPokemonAPI();
        Call<PokemonPlaceHolder> call = pokemonAPI.getPokemon(pokemonName);
        call.enqueue(new Callback<PokemonPlaceHolder>() {
            @Override
            public void onResponse(Call<PokemonPlaceHolder> call, Response<PokemonPlaceHolder> response) {
                if(response.code() == 200)
                {
                    pokemon.setValue(response.body().getPokemon());
                }
            }

            @Override
            public void onFailure(Call<PokemonPlaceHolder> call, Throwable t) {
                Log.i("ERROR","Something has to be fixed");
            }
        });
    }



}
