package com.example.examentecnico.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examentecnico.core.Constantes
import com.example.examentecnico.models.PeliculaModel
import com.example.examentecnico.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PeliculasViewModel: ViewModel() {
    private var _listaPeliculas = MutableLiveData<List<PeliculaModel>>()
    val listaPeliculas: LiveData<List<PeliculaModel>> = _listaPeliculas

    fun obtenerCartelera() {
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerCartelera(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
            }
        }
    }

    fun obtenerPopulares(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerPopulares(Constantes.API_KEY)
            withContext(Dispatchers.Main){
                _listaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.votoPromedio }
            }
        }
    }
}