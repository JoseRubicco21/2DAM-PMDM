package com.tareas.imccalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultIMCFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultIMCFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result_i_m_c, container, false)
        val pesoText = view.findViewById<TextView>(R.id.pesoText)
        val imcText = view.findViewById<TextView>(R.id.imcText)
        val descText = view.findViewById<TextView>(R.id.descText)
        val recalculateButton = view.findViewById<Button>(R.id.recalc)

        val imc = ResultIMCFragmentArgs.fromBundle(requireArguments()).result
        val str = "%.2f".format(imc)
        println(imc)
        println(str)

        imcText.text = str

        when {
            imc < 18.5 -> {
                pesoText.text = "Baixo peso"
                pesoText.setTextColor("#FF00FF".toColorInt())
                descText.text = "El peso esta por debajo de lo usual"
            }
            imc in 18.5..< 25.0 -> {
                pesoText.text = "Normal"
                pesoText.setTextColor("#FFFF00".toColorInt())
                descText.text = "El peso es normal"
            }
            imc in 25.0 ..< 30.0 -> {
                pesoText.text = "Sobrepeso"
                pesoText.setTextColor("#00FFFF".toColorInt())
                descText.text = "El peso esta por encima de lo usual"
            }
            imc >= 30.00 -> {
                pesoText.text = "Obesidad"
                pesoText.setTextColor("#FF0000".toColorInt())
                descText.text = "El peso esta muy por encima de lo optimo"
            }
        }

        recalculateButton.setOnClickListener(){
            view.findNavController().navigate(R.id.IMCCalculatorFragment)
        }
        return  view
    }

}