package com.example.ud6_pokedex.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ud6_pokedex.MainApplication
import com.example.ud6_pokedex.conexion.ServicioApi
import com.example.ud6_pokedex.datos.repositorio.PokemonRepo_Conexion
import com.example.ud6_pokedex.datos.repositorio.TipoRepo_Conexion
import com.example.ud6_pokedex.modelo.respuesta.RespuestaPokemon
import com.example.ud6_pokedex.modelo.respuesta.RespuestaTipo
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

// INTERFACES SELLADAS //////////////////////////////////////////////
/**
 * Cada interfaz contiene una serie de estados,
 * para ejecutar uno u otro comportamiento segun el estado actual.
 */

sealed interface UIState_Pokemon{
    data class Exito(val respuesta: RespuestaPokemon): UIState_Pokemon
    object Error: UIState_Pokemon
    object Cargando: UIState_Pokemon
}

sealed interface UIState_Tipo{
    data class Exito(val respuesta: RespuestaTipo): UIState_Tipo
    object Error: UIState_Tipo
    object Cargando: UIState_Tipo
}

// CLASE VIEWMODEL //////////////////////////////////////////////////
/**
 * Contiene:
 * <> 1 instancia de cada interfaz
 * <> 1 metodo init, que se ejecuta nada mas empezar
 * <> metodos para obtener las respuestas de las interfaces
 * Tambien se le debe pasar una instancia de cada repositorio.
 * Por ultimo, el 'companion object' es un metodo que permite crear instancias
 * del 'MainViewModel', ya que por defecto no utiliza constructor propio.
 */

class MainViewModel(
    private val pokemonRepo: PokemonRepo_Conexion,
    private val tipoRepo: TipoRepo_Conexion
): ViewModel() {
    var UIS_Pokemon: UIState_Pokemon by mutableStateOf(UIState_Pokemon.Cargando)
        private set

    var UIS_Tipo: UIState_Tipo by mutableStateOf(UIState_Tipo.Cargando)
        private set

    init{
        recopilarPokemones()
    }

    fun recopilarPokemones(){
        viewModelScope.launch {
            UIS_Pokemon = UIState_Pokemon.Cargando
            UIS_Pokemon = try {
                val listaPokemon = pokemonRepo.obtenerListaPokemon()
                UIState_Pokemon.Exito(listaPokemon)
            } catch (e: IOException){
                UIState_Pokemon.Error
            } catch (e: HttpException){
                UIState_Pokemon.Error
            }
        }
    }

    fun recopilarTipos(){
        viewModelScope.launch {
            UIS_Tipo = UIState_Tipo.Cargando
            UIS_Tipo = try {
                val listaTipos = tipoRepo.obtenerListaTipos()
                UIState_Tipo.Exito(listaTipos)
            } catch (e: IOException){
                UIState_Tipo.Error
            } catch (e: HttpException){
                UIState_Tipo.Error
            }
        }
    }

    companion object {
        val constructor: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val _aplicacion = (this[APPLICATION_KEY] as MainApplication)
                val _pokemonRepo = _aplicacion._contenedor.PokemonRepo
                val _tipoRepo = _aplicacion._contenedor.TipoRepo
                MainViewModel(
                    pokemonRepo = _pokemonRepo,
                    tipoRepo = _tipoRepo
                )
            }
        }
    }
}