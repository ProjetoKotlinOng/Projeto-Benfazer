package com.generation.benfazerproject.repository

import com.generation.benfazerproject.api.RetrofitInstance
import com.generation.benfazerproject.modelo.Categoria
import com.generation.benfazerproject.modelo.Produto
import retrofit2.Response

class Repository {
    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addProduto(produto: Produto): Response<Produto> {
        return RetrofitInstance.api.addProduto(produto)
    }

}
