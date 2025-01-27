package com.example.ud6_pokedex.datos.repositorio

import com.example.ud6_pokedex.conexion.ServicioApi
import com.example.ud6_pokedex.modelo.objeto.Pokemon
import com.example.ud6_pokedex.modelo.respuesta.RespuestaPokemon

// REPOSITORIO POKEMON //////////////////////////////////////////////
/**
 * Cada archivo repositorio consta de una interfaz y una clase:
 * <> La interfaz define los metodos que debe implementar la clase
 * <> La clase recopila un objeto '_servicioApi' para establecer la conexion con JSON
 * A partir de '_servicioApi', la clase sobreescribe los metodos de la interfaz
 */

interface PokemonRepo_Interfaz {
    suspend fun obtenerListaPokemon(): RespuestaPokemon
    suspend fun seleccionarPokemon(): Pokemon
}

class PokemonRepo_Conexion (
    private val _servicioApi: ServicioApi
): PokemonRepo_Interfaz {
    override suspend fun obtenerListaPokemon(): RespuestaPokemon = _servicioApi.getPokemonList(offset = 0,limit = 30)
    override suspend fun seleccionarPokemon(): Pokemon = _servicioApi.getPokemonData(0)
}