package com.generation.benfazerproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.benfazerproject.databinding.FragmentFormularioBinding
import com.generation.benfazerproject.modelo.Categoria
import com.generation.benfazerproject.modelo.Produto


class FormularioFragment : Fragment() {

    private lateinit var binding: FragmentFormularioBinding

    private var categoriaSelecionada = 0L

    private val mainViewModel: MainViewModel by activityViewModels()

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
            val editQuantText = binding.editQuant.text.toString().toInt()
            val editValorText = binding.editValor.text.toString().toInt()

            if (validarCampos(editDescText, editProdText, editQuantText, editValorText)) {
                val toast =
                    Toast.makeText(context, "Preencher os campos obrigatorios", Toast.LENGTH_LONG)
                toast.show()
            } else {
                findNavController().navigate(R.id.action_formularioFragment_to_listFragment)
                Toast.makeText(context, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonCadastrar.setOnClickListener {
            inserirNoBanco()
        }

        return binding.root
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
        editValor: Int,
        editQuant: Int,
    ): Boolean {
        return !(
                (editProd == "" || editProd.length <0  || editProd.length>255) ||
        (editDesc == "" || editDesc.length <0 || editDesc.length > 1000) ||
        (editValor == 0) ||
                (editQuant == 0)
                )
    }

    fun inserirNoBanco (){

        val prod = binding.editProd.text.toString()
        val desc = binding.editDesc.text.toString()
        val quant = binding.editQuant.text.toString().toInt()
        val valor = binding.editValor.text.toString().toInt()
        val image = binding.editImage.text.toString()
        val categoria = Categoria(categoriaSelecionada,null,null)

        if(validarCampos(prod, desc,valor,quant,)){
            val produto = Produto(0,prod,desc,image,quant,valor,categoria)

            mainViewModel.addProduto(produto)
            Toast.makeText(context,"Tarefa Salva!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_listFragment_to_formularioFragment)}

        else{
            Toast.makeText(context,"Preencha os campos corretamente!",Toast.LENGTH_LONG).show()
        }

    }
}



