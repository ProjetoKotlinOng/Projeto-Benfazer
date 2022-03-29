package com.generation.benfazerproject.modelo

data class Produto (
    var id: Long,
    var nomeMarca: String,
    var descricao: String,
    var imagem: String,
    var quantidade: Int,
    var valor: Number,
    var categoria: Categoria
    ){
    }