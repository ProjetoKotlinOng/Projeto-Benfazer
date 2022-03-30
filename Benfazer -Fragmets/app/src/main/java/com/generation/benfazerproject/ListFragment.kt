package com.generation.benfazerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.benfazerproject.adapter.Adapter
import com.generation.benfazerproject.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel.listProduto()

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val adapter = Adapter()

        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)

        binding.recyclerProduto.adapter = adapter

        binding.recyclerProduto.setHasFixedSize(true)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formularioFragment)
        }

        mainViewModel.myProdutoResponse.observe(viewLifecycleOwner) { response ->
            if (response != null) {
                adapter.setList(response.body()!!)
            }
        }

        return binding.root
    }
}