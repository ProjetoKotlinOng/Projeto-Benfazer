package com.generation.benfazerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.generation.benfazerproject.adapter.Adapter
import com.generation.benfazerproject.databinding.FragmentListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val adapter = Adapter()

        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)

        binding.recyclerProduto.adapter = adapter

        binding.recyclerProduto.setHasFixedSize(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formularioFragment)
        }

        return view
    }
}