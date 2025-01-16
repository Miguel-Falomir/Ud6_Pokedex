package com.example.ud6_pokedex.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ud6_pokedex.ui.viewmodel.UIState_Pokemon

@Composable
fun PantallaListaPokemones(
    uisPokemon: UIState_Pokemon,
    modifier: Modifier = Modifier
){
    when (uisPokemon) {
        is UIState_Pokemon.Cargando -> PantallaCargando(modifier.fillMaxSize())
        is UIState_Pokemon.Error -> PantallaError(modifier.fillMaxSize())
        is UIState_Pokemon.Exito -> ListaPokemones(
            uisPokemon,
            modifier.fillMaxSize()
        )
    }
}

@Composable
fun ListaPokemones(
    uisPokemon: UIState_Pokemon,
    modifier: Modifier = Modifier
){

}