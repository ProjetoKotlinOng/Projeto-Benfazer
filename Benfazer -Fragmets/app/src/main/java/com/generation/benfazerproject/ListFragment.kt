package com.generation.benfazerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.benfazerproject.adapter.Adapter
import com.generation.benfazerproject.modelo.Post
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val listPost = mutableListOf(
            Post(
                "Adicionar o link",
                "Sonhar Acordado",
                "Atendemos crianças em situação de vunerabilidade"
            ),
                    Post (
                    "Adicionar o link",
            "Gás",
            "Atendemos pessoas e animais em situação de rua"
        ),
            Post(
                "Adicionar o link",
                "Teto",
                "Ajuda na construção de casas para famílias carentes"
            )
        )
        val recyclerPost = view.findViewById<RecyclerView>(R.id.recyclerPost)

        val floatingActionButton= view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        val adapter = Adapter()

        recyclerPost.layoutManager = LinearLayoutManager(context)

        recyclerPost.adapter = adapter

        recyclerPost.setHasFixedSize(true)

        adapter.setList(listPost)

        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formularioFragment)
        }

        return view
    }
}