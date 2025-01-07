package com.example.ud6_pokedex.modelo.respuesta

import com.example.ud6_pokedex.modelo.objeto.Link
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// CLASE RESPUESTA TIPO /////////////////////////////////////////////
/**
 * Contiene todos los atributos de la busqueda:
 * <> Cantidad total de objetos
 * <> Enlace a paginas siguiente y anterior ('null' si no hay pagina)
 * <> Lista de objetos encontrados
 */

@Serializable
data class RespuestaTipo(
    @SerialName(value = "count")
    val total: Int,
    @SerialName(value = "next")
    val pagSiguiente: String?,
    @SerialName(value = "previous")
    val pagAnterior: String?,
    @SerialName(value = "results")
    val listaPokemon: List<Link>
)
