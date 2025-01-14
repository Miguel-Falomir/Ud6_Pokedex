package com.example.ud6_pokedex.datos.repositorio

import com.example.ud6_pokedex.conexion.ServicioApi
import com.example.ud6_pokedex.modelo.objeto.TipoPokemon
import com.example.ud6_pokedex.modelo.respuesta.RespuestaTipo

// REPOSITORIO TIPO /////////////////////////////////////////////////
/**
 * Cada archivo repositorio consta de una interfaz y una clase:
 * <> La interfaz define los metodos que debe implementar la clase
 * <> La clase recopila un objeto '_servicioApi' para establecer la conexion con JSON
 * A partir de '_servicioApi', la clase sobreescribe los metodos de la interfaz
 */

interface TipoRepo_Interfaz {
    suspend fun obtenerListaTipos(): RespuestaTipo
    suspend fun seleccionarTipo(): TipoPokemon
}

class TipoRepo_Conexion (
    private val _servicioApi: ServicioApi
): TipoRepo_Interfaz {
    override suspend fun obtenerListaTipos(): RespuestaTipo = _servicioApi.getTypeList(0,10)
    override suspend fun seleccionarTipo(): TipoPokemon = _servicioApi.getTypeData(0)
}