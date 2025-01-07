package com.example.ud6_pokedex.conexion

import com.example.ud6_pokedex.modelo.objeto.Pokemon
import com.example.ud6_pokedex.modelo.respuesta.RespuestaPokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// INTERFAZ APISERVICE //////////////////////////////////////////////
/**
 * Cada metodo importa de BD remota un tipo de objeto JSON.
 * 'getPokemonList' importa lista pokemons y la formatea en un objeto 'RespuestaPokemon'.
 * 'getPokemonData' recibe u ID, importa datos del pokemon al que apunta dicho ID y los formatea en un objeto 'Pokemon'.
 * @Query envia parametros a BD remota. En este caso:
 * <> 'limit' indica la cantidad de resultados que debe mostrar cada pagina
 * <> 'offset' indica cuantos resultados debe saltarse, contando desde el primero
 * @Path inserta valores dinamicos en la URL de la busqueda. En este caso:
 * <> 'id' apunta a un pokemon especifico de la BD
 */

interface ServicioApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): RespuestaPokemon

    @GET("pokemon/{id}")
    suspend fun getPokemonData(
        @Path("id") id: Int
    ): Pokemon
}