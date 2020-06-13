package com.example.navbarzzleep.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("api/v2/pokemon/{name}")
    Call<PokemonPlaceHolder> getPokemon(@Path("name") String name);
}
