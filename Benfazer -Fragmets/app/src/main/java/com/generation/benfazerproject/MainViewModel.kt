package com.generation.benfazerproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.benfazerproject.modelo.Categoria
import com.generation.benfazerproject.modelo.Produto
import com.generation.benfazerproject.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository
    ): ViewModel() {

    private var _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    init {
        listCategoria()
    }

    fun listCategoria() {
        viewModelScope.launch {
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response
            } catch (e: Exception) {
                Log.d("Erro", e.message.toString())
            }
        }
    }

    fun addProduto(produto: Produto){
        viewModelScope.launch {
            try {
                repository.addProduto(produto)
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }
}
