package com.example.navbarzzleep.network;

public class PokemonPlaceHolder {

    private int id;
    private String name;
    private Sprites sprites;

    public Pokemon getPokemon(){
        return new Pokemon(id,name,sprites.front_default);
    }

    private class Sprites{
        private String front_default;
    }

}
