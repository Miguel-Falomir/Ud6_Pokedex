package com.example.ud6_pokedex.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ud6_pokedex.modelo.objeto.Link
import com.example.ud6_pokedex.ui.viewmodel.UIState_Pokemon

// PANTALLA LISTAR POKEMONES ////////////////////////////////////////
/**
 * Este archivo contiene 2 metodos:
 * <> 'PantallaListaPokemones' toma el objeto 'UIState_Pokemon',
 * y muestra una u otra pantalla segun el estado de dicho uistate
 * <> 'ListaPokemones' muestra la lista de pokemones que contiene el uistate,
 * y se invoca solo si uistate = UIState_Pokemon.Exito()
 */

@Composable
fun PantallaListaPokemones(
    uisPokemon: UIState_Pokemon,
    modifier: Modifier = Modifier
){
    when (uisPokemon) {
        is UIState_Pokemon.Cargando -> PantallaCargando(modifier.fillMaxSize())
        is UIState_Pokemon.Error -> PantallaError(modifier.fillMaxSize())
        is UIState_Pokemon.Exito -> ListaPokemones(
            uisPokemon.respuesta.listaPokemon,
            modifier.fillMaxSize()
        )
    }
}

@Composable
fun ListaPokemones(
    listaPokemon: List<Link>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = modifier
    ) {
        items(listaPokemon.size){ index ->
            Card (
                modifier = Modifier.padding(10.dp)
            ){
                Column (
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .height(100.dp)
                        .align(Alignment.CenterHorizontally)
                ){
                    Spacer(Modifier.weight(1F))
                    Text(
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                        fontSize = 24.sp,
                        text = listaPokemon.get(index).nombre
                    )
                    Spacer(Modifier.weight(1F))
                }
            }
        }
    }
}