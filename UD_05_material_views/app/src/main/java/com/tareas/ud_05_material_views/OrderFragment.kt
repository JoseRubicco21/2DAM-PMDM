package com.tareas.ud_05_material_views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.tareas.ud_05_material_views.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {


    private  var _binding : FragmentOrderBinding? = null

    private  val binding: FragmentOrderBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOrderBinding.inflate(inflater, container, false)

        val view = binding.root
        val toolbar = binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val fab = binding.fab2

        fab.setOnClickListener(){
            val pizzaGroup = binding.groupPizzaType
            val pizzaType = binding.groupPizzaType.id
            var msg =""
            var parmessan = binding.chipParmesano
            var tomate = binding.chipTomateCherry

            if(pizzaType == -1){
                msg = "Debes seleccionar un tipo de pizza"
                Toast.makeText(activity, msg , Toast.LENGTH_SHORT).show()
            } else {
                msg = "Seleccionaste un tipo de pizza"
            }

            msg += when (pizzaType){
                R.id.radio_margarita -> "Margarita"
                R.id.radio_calzone -> "Calzone"
                else -> "Produció un error"
            }

            if(parmessan.isChecked) msg += "parmesano"
            if(tomate.isChecked) msg += "Tomate cherry"

            val snackbar = Snackbar.make(fab, msg, Snackbar.LENGTH_SHORT)
            snackbar.setAction("Undo"){
                pizzaGroup.clearCheck()
                parmessan.isChecked=false
                tomate.isChecked=false
            }
            snackbar.show()
        }



        return view
        // Inflate the layout for this fragment
    }


}