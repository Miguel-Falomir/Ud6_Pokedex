package com.example.ud6_pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ud6_pokedex.ui.theme.Ud6_PokedexTheme
import com.example.ud6_pokedex.ui.viewmodel.MainViewModel

// LISTA TITULOS PANTALLAS //////////////////////////////////////////
/**
 * Cada titulos tiene asignado un 'stringRes'
 */

enum class listaPantallas(@StringRes val titulo: Int){
    Inicio(titulo = R.string.pantalla_inicio),
    Pokemones(titulo = R.string.pantalla_lista_pokemones),
    Tipos(titulo = R.string.pantalla_lista_tipos)
}

// CLASE PRINCIPAL //////////////////////////////////////////////////
/**
 * Invoca al metodo Navegador()
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud6_PokedexTheme {
                Navegador()
            }
        }
    }
}

// METODO NAVEGADOR /////////////////////////////////////////////////
/**
 * Permite navegar entre las distintas pantallas de la aplicacion.
 * Cada pantalla tiene asignada una ruta, determinada por un titulo de 'listaPantallas'.
 */

@Composable
fun Navegador(
    _viewModel: MainViewModel = viewModel(factory = MainViewModel.constructor),
    _navController: NavHostController = rememberNavController()
){
    val pilaRetroceso by _navController.currentBackStackEntryAsState()

    val pantallaActual = listaPantallas.valueOf(
        pilaRetroceso?.destination?.route?: listaPantallas.Inicio.name
    )

    Scaffold (
        topBar = {

        }
    ){ innerPadding ->
        val uisPokemon = _viewModel.UIS_Pokemon
        val uisTipo = _viewModel.UIS_Tipo

        NavHost(
            navController = _navController,
            startDestination = listaPantallas.Inicio.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = listaPantallas.Inicio.name){

            }
            composable(route = listaPantallas.Pokemones.name){

            }
            composable(route = listaPantallas.Tipos.name){

            }
        }
    }
}