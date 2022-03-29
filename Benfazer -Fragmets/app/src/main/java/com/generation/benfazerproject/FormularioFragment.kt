package com.generation.benfazerproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.generation.benfazerproject.databinding.FragmentFormularioBinding
import com.generation.benfazerproject.modelo.Categoria


class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    private var categoriaSelecionada = 0L

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFormularioBinding.inflate(layoutInflater, container, false)

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisição", response.body().toString())
            spinnerLista(response.body())
        }

        binding.buttonCadastrar.setOnClickListener {


            val editProdText = binding.editProd.text.toString()
           // val editImageText = binding.editImage.text.toString()
            val editDescText = binding.editDesc.text.toString()
            val editQuantText = binding.editQuant.text.toString()
            val editValorText = binding.editValor.text.toString()

            if (validarCampos(editDescText, editProdText, editQuantText, editValorText) == true) {
                val toast =
                    Toast.makeText(context, "Preencher os campos obrigatorios", Toast.LENGTH_LONG)
                toast.show()
            } else {
                findNavController().navigate(R.id.action_formularioFragment_to_listFragment)
                Toast.makeText(context, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }

    fun spinnerLista(categoria: List<Categoria>?) {
        if (categoria != null) {
            binding.spinnerLista.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                categoria
            )

            binding.spinnerLista.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        val categoriaSelecionadaFun = binding
                            .spinnerLista.selectedItem as Categoria
                        categoriaSelecionada = categoriaSelecionadaFun.id
                    }
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }
                }
        }
    }

    fun validarCampos(
        editProd: String,
        editDesc: String,
        editValor: String,
        editQuant: String,
    ): Boolean {
        return !(
                (editProd == "" || editDesc == "" || editValor == "" || editQuant == "")
                )
    }
}



