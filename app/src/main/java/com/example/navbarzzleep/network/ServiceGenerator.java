package com.example.navbarzzleep.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static PokemonAPI pokemonAPI = retrofit.create(PokemonAPI.class);

    public static PokemonAPI getPokemonAPI() {return pokemonAPI;}
}
