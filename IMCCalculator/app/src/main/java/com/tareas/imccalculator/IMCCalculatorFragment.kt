package com.tareas.imccalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorInt
import androidx.core.graphics.toColorLong
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IMCCalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IMCCalculatorFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_i_m_c_calculator, container, false)

        var selectedSex = ""
        var peso : Int = 0
        var altura : Float = 0.0f
        var edad : Int = 0
        var imc : Float = 0.0f



        val hombreButton = view.findViewById<MaterialCardView>(R.id.hombreCard)
        val mujerButton = view.findViewById<MaterialCardView>(R.id.mujerCard)

        hombreButton.setOnClickListener(){
            selectedSex = "h"
            if(selectedSex.equals("h")) {
                val color = context?.getColor(R.color.selected_card)
                hombreButton.setBackgroundColor(color!!)
                val colorOff = context?.getColor(R.color.background_light)
                mujerButton.setBackgroundColor(colorOff!!)
            }
        }

        mujerButton.setOnClickListener(){
            selectedSex = "m"
            if(selectedSex.equals("m")) {
                val color = context?.getColor(R.color.selected_card)
                mujerButton.setBackgroundColor(color!!)
                val colorOff = context?.getColor(R.color.background_light)
                hombreButton.setBackgroundColor(colorOff!!)
            }
        }
        val slider = view.findViewById<RangeSlider>(R.id.slider)
        val sliderText = view.findViewById<TextView>(R.id.AlturaText)



        slider.addOnChangeListener(){ _, value, _ ->
            altura = value
            val sb : StringBuilder = StringBuilder()
            sb.append(value.toInt())
            sb.append(" cm")
            val str = sb.toString();

            sliderText.text = str
        }

        val pesoText = view.findViewById<TextView>(R.id.pesoText)
        val edadText = view.findViewById<TextView>(R.id.edadText)

        val pesoPlusSign = view.findViewById<FloatingActionButton>(R.id.peso_plus_button)
        val pesoMinusSign = view.findViewById<FloatingActionButton>(R.id.peso_minus_button)

        val edadPlusSign = view.findViewById<FloatingActionButton>(R.id.edad_plus_button)
        val edadMinusSing = view.findViewById<FloatingActionButton>(R.id.edad_minus_button)

        pesoPlusSign.setOnClickListener(){
            peso = addToValue(pesoText)
        }
        pesoMinusSign.setOnClickListener(){
           peso = substractToValue(pesoText)
        }

        edadPlusSign.setOnClickListener(){
           edad = addToValue(edadText)
        }

        edadMinusSing.setOnClickListener(){
           edad = substractToValue(edadText)
        }

        val calcButton = view.findViewById<Button>(R.id.calcular_button)

        calcButton.setOnClickListener(){
            imc = calculateIMC(peso, altura)
            val actions = IMCCalculatorFragmentDirections.actionIMCCalculatorFragmentToResultIMCFragment(imc)
            view.findNavController().navigate(actions)
        }



        return  view
    }


    private fun addToValue(textElement: TextView) : Int {
        var value = textElement.text.toString().toInt()
        if(value >= 0){
            value = (textElement.text.toString().toInt()+1)
            textElement.text = value.toString()
        } else {
            value = 0
            textElement.text = value.toString()
        }

        return value;
    }


    private fun substractToValue(textElement: TextView) : Int{
        var value = textElement.text.toString().toInt()
        if(value > 0){
            value = (textElement.text.toString().toInt()-1)
            textElement.text = value.toString()
        } else {
            value = 0
            textElement.text = value.toString()
        }

        return value
    }

    private fun calculateIMC(peso : Int, altura : Float) : Float{
        val alturaFixed = altura / 100
        return  peso/(alturaFixed*alturaFixed)
    }
}