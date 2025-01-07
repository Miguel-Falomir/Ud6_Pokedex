package com.example.ud6_pokedex.modelo.objeto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// CLASE CONTENEDOR ATRIBUTOS ///////////////////////////////////////
/**
 * Contiene los atributos del repositorio a que Link.url apunta.
 * No necesariamente debe contener TODOS los atributos del JSON, solo aquellos que se vayan a utilizar en el programa.
 * En este caso, apunta a un objeto JSON de tipo 'pokemon'
 */

@Serializable
data class Pokemon(
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "name")
    val nombre: String,
    @SerialName(value = "types")
    val listaTipos: List<PokemonSlotTipo>
)

// CLASES CASILLA SUBOBJETOS ////////////////////////////////////////
/**
 * Algunos objetos pueden contener un atributo lista de objetos.
 * Esta lista contiene varios 'slots', y cada slot contiene: un numero de identificacion y un 'Link'.
 */

@Serializable
data class PokemonSlotTipo(
    @SerialName(value = "slot")
    val slot: Int,
    @SerialName(value = "type")
    val tipo: Link
)