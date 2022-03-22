package com.generation.benfazerproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.benfazerproject.R
import com.generation.benfazerproject.modelo.Post

class Adapter : RecyclerView.Adapter<Adapter.PostViewHolder>() {
    private var list = emptyList<Post>()

    class PostViewHolder(View: View) : RecyclerView.ViewHolder(View) {
        val ImageOng = View.findViewById<ImageView>(R.id.ImageOng)
        val NomeOng = View.findViewById<TextView>(R.id.NomeOng)
        val Descricao = View.findViewById<TextView>(R.id.Descricao)
        val DoarButton = View.findViewById<Button>(R.id.DoarButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return PostViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]
        holder.NomeOng.text = post.nome
        holder.Descricao.text = post.descricao
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(listPost: MutableList<Post>) {
        list = listPost
        notifyDataSetChanged()
    }
}