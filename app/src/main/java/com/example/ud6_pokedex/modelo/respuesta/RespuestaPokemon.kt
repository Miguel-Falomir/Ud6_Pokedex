package com.example.ud6_pokedex.modelo.respuesta

import com.example.ud6_pokedex.modelo.objeto.Link
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// CLASE RESPUESTA POKEMON //////////////////////////////////////////
/**
 *
 */

@Serializable
data class RespuestaPokemon(
    @SerialName(value = "count")
    val total: Int,
    @SerialName(value = "next")
    val pagSiguiente: String?,
    @SerialName(value = "previous")
    val pagAnterior: String?,
    @SerialName(value = "results")
    val listaPokemon: List<Link>
)
