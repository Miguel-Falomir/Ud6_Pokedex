package com.example.ud6_pokedex.modelo.objeto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// CLASE ENLACE /////////////////////////////////////////////////////
/**
 * Contiene los atributos comunes a todos los enlaces:
 * <> nombre del objeto al que apunta
 * <> enlace al repositorio en que se almacena
 * @Serializable indica que toda la clase apunta a un objeto JSON.
 * @SerialName(value = "") busca un valor que se llame igual que el 'name', y se lo asigna al atributo colindante.
 */

@Serializable
data class Link(
    @SerialName(value = "name")
    val nombre: String,
    @SerialName(value = "url")
    val enlace: String
)