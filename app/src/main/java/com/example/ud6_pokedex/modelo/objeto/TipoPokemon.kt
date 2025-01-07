package com.example.ud6_pokedex.modelo.objeto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// CLASE CONTENEDOR ATRIBUTOS ///////////////////////////////////////
/**
 * Contiene los atributos del repositorio a que Link.url apunta.
 * No necesariamente debe contener TODOS los atributos del JSON, solo aquellos que se vayan a utilizar en el programa.
 * En este caso, apunta a un objeto JSON de tipo 'type'
 */

@Serializable
data class TipoPokemon(
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "name")
    val nombre: String
)