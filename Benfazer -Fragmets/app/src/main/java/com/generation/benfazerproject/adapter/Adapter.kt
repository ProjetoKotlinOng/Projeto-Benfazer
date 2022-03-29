package com.generation.benfazerproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.benfazerproject.R
import com.generation.benfazerproject.modelo.Produto

class Adapter : RecyclerView.Adapter<Adapter.ProdutoViewHolder>() {
    private var list = emptyList<Produto>()

    class ProdutoViewHolder(View: View) : RecyclerView.ViewHolder(View) {
        val textProd = View.findViewById<TextView>(R.id.textProd)
        val textQuant = View.findViewById<TextView>(R.id.textQuant)
        val textDesc = View.findViewById<TextView>(R.id.textDesc)
        val textValor = View.findViewById<TextView>(R.id.textValor)
        val textCategoria = View.findViewById<TextView>(R.id.textCategoria)
        val ImageOng = View.findViewById<ImageView>(R.id.ImageOng)
        val ComprarButton = View.findViewById<Button>(R.id.ComprarButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return ProdutoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = list[position]
        holder.textProd.text = produto.nomeMarca
        holder.textDesc.text = produto.descricao
        holder.textValor.text = produto.valor.toString()
        holder.textQuant.text = produto.quantidade.toString()
        holder.textCategoria.text = produto.categoria.descricao

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(listProduto: MutableList<Produto>) {
        list = listProduto
        notifyDataSetChanged()
    }
}