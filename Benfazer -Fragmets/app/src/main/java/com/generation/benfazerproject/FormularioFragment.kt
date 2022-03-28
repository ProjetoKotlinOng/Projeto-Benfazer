package com.generation.benfazerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.find

class FormularioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_formulario, container, false)

        val buttonCadastrar = view.findViewById<Button>(R.id.buttonCadastrar)
        buttonCadastrar.setOnClickListener {

            val NOng = view.findViewById<EditText>(R.id.NOng)
            val cnpj = view.findViewById<EditText>(R.id.cnpj)
            val DescAtiv = view.findViewById<EditText>(R.id.DescAtiv)
            val VArrecadar = view.findViewById<EditText>(R.id.VArrecadar)
            val Banco = view.findViewById<EditText>(R.id.Banco)

            val NOngText = NOng.text.toString()
            val cnpjText = cnpj.text.toString()
            val DescAtivText = DescAtiv.text.toString()
            val VArrecadarText = VArrecadar.text.toString()
            val BancoText = Banco.text.toString()

            if (validarCampos(NOngText, cnpjText,DescAtivText, VArrecadarText, BancoText)== true) {
            val toast = Toast.makeText(context, "Preencher os campos obrigatorios", Toast.LENGTH_LONG)
                toast.show()
            }
            else{
                findNavController().navigate(R.id.action_formularioFragment_to_listFragment)
                Toast.makeText(context, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
            }
        }
        return view

    }

    fun validarCampos(NOng:String,cnpj:String,DescAtiv:String,VArrecadar:String,
    Banco:String): Boolean {
        return NOng == "" || cnpj == "" || DescAtiv == "" || VArrecadar == ""
                || Banco == ""
    }

}

