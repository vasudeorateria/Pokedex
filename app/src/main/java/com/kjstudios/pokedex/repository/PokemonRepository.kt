package com.kjstudios.pokedex.repository

import com.kjstudios.pokedex.data.remote.PokemonApi
import com.kjstudios.pokedex.data.remote.response.Pokemon
import com.kjstudios.pokedex.data.remote.response.PokemonList
import com.kjstudios.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val pokemonApi: PokemonApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return try {
            Resource.Success(pokemonApi.getPokemonList(limit, offset))
        }catch (exception : Exception){
            Resource.Error(message = "An unknown error occurred")
        }
    }

    suspend fun getPokemon(pokemonName : String): Resource<Pokemon> {
        return try {
            Resource.Success(pokemonApi.getPokemon(pokemonName))
        }catch (exception : Exception){
            Resource.Error(message = "An unknown error occurred")
        }
    }

}