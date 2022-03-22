package com.generation.benfazerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FormularioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_formulario, container, false)

        val buttonCadastrar = view.findViewById<Button>(R.id.buttonCadastrar)

        buttonCadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_formularioFragment_to_listFragment)
        }

        return view
    }
}