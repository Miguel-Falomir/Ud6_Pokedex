package com.example.ud6_pokedex

import android.app.Application
import com.example.ud6_pokedex.datos.contenedor.ContenedorApp

// APLICACION PRINCIPAL /////////////////////////////////////////////
/**
 * Aplicacion matriz de toodo el programa
 * Contiene una instancia de la clase 'ContenedorApp',
 * y la inicializa al arrancar/prender el programa
 */

class MainApplication: Application() {

    lateinit var _contenedor: ContenedorApp

    override fun onCreate() {
        super.onCreate()
        _contenedor = ContenedorApp()
    }
}