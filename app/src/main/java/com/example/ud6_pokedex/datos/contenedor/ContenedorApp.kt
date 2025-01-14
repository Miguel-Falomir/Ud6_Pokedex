package com.example.ud6_pokedex.datos.contenedor

import com.example.ud6_pokedex.conexion.ServicioApi
import com.example.ud6_pokedex.datos.repositorio.PokemonRepo_Conexion
import com.example.ud6_pokedex.datos.repositorio.TipoRepo_Conexion
import com.example.ud6_pokedex.datos.repositorio.TipoRepo_Interfaz
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

// CONTENEDOR PRINCIPAL DATOS PROGRAMA //////////////////////////////
/**
 * El archivo consta de una interfaz 'ContenedorApp_Interfaz' y una clase 'ContenedorApp'
 * La interfaz 'ContenedorApp_Interfaz' contiene un valor para cada repositorio
 * La clase 'ContenedorApp' consta de 4 variables internas para establecer la conexion:
 * <> '_enlaceBaseDatos' es un String con el enlace al directorio matriz de toda la BD
 * <> '_conversorJSON' permite convertir los resultados JSON a clases paquete 'modelo'
 * <> '_retrofit' es una instancia de la interfaz 'Retrofit' generada con atributos 'enlaceBaseDatos' y 'conversorJSON'
 * <> '_servicioRetrofit' es una instancia de la interfaz 'ServicioApi' generada mediante 'retrofit'
 * Tambien implementa la interfaz para sobreescribir los repositorios con la informacion recopilada
 */

interface ContenedorApp_Interfaz {
    val PokemonRepo: PokemonRepo_Conexion
    val TipoRepo: TipoRepo_Conexion
}

class ContenedorApp: ContenedorApp_Interfaz {

    // variables conexion

    private val _enlaceBaseDatos = "https://pokeapi.co/api/v2/"

    private val _conversorJSON = Json { ignoreUnknownKeys = true }

    private val _retrofit = Retrofit.Builder()
        .addConverterFactory(_conversorJSON.asConverterFactory("application/json".toMediaType()))
        .baseUrl(_enlaceBaseDatos)
        .build()

    private val _servicioRetrofit: ServicioApi by lazy {
        _retrofit.create(ServicioApi::class.java)
    }

    // instancias repositorios

    override val TipoRepo: TipoRepo_Conexion by lazy {
        TipoRepo_Conexion(_servicioRetrofit)
    }

    override val PokemonRepo: PokemonRepo_Conexion by lazy {
        PokemonRepo_Conexion(_servicioRetrofit)
    }
}