package com.tarea.velocidad

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tarea.velocidad.databinding.ActivityMainBinding
import io.github.muddz.styleabletoast.StyleableToast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var kmh = 0.0
    private var ms = 0.0

    // --- Velocity functions ---
    private fun averageVelocityMS(distanceMeters: Int, timeSeconds: Int): Double {
        if (distanceMeters < 0 || timeSeconds < 0)
            throw IllegalArgumentException("Distance and time must be positive numbers")

        if (timeSeconds == 0) return 0.0
        this.ms = distanceMeters.toDouble() / timeSeconds.toDouble()
        return  this.ms
    }

    private fun averageVelocityKMH(distanceMeters: Int, timeSeconds: Int): Double {
        this.kmh = averageVelocityMS(distanceMeters, timeSeconds) * 3.6
        return kmh
    }

    private fun updateImg(){
        when {
            kmh < 30.0 ->   binding.velocityIcon.setImageResource(R.drawable.turtle_icon)
            kmh in 30.0..70.0 -> binding.velocityIcon.setImageResource(R.drawable.dog_icon)
            kmh > 70.0 -> binding.velocityIcon.setImageResource(R.drawable.tiger_icon)
            else -> binding.velocityIcon.setImageResource(R.drawable.ic_launcher_foreground)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)


        // Update results when *either* distance or time changes
        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateValues()
                updateImg()
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        binding.distanceEditText.addTextChangedListener(watcher)
        binding.timeEditText.addTextChangedListener(watcher)
    }


    // --- Calculate & update UI safely ---
    private fun updateValues() {
        val distanceStr = binding.distanceEditText.text.toString()
        val timeStr = binding.timeEditText.text.toString()

        val distance = distanceStr.toIntOrNull()
        val time = timeStr.toIntOrNull()

        // Validate numeric input
        if (distance == null) {
            StyleableToast.Builder(applicationContext)
                .text("Error. Introduce un numero valido")
                .textSize(16.0f)
                .textColor(Color.WHITE)
                .backgroundColor(Color.RED)
                .cornerRadius(20)
                .show()
            return
        }
        if (time == null) {
            binding.timeEditText.error = "Enter a valid number"
            StyleableToast.Builder(applicationContext)
                .text("Error. Introduce un numero valido")
                .textSize(16.0f)
                .textColor(Color.WHITE)
                .backgroundColor(Color.RED)
                .cornerRadius(20)
                .show()

                return
        }

        // Perform calculations safely
        val mps = averageVelocityMS(distance, time)
        val kmh = averageVelocityKMH(distance, time)

        // Display results
        binding.mSTextView.text = "%.2f".format(mps)
        binding.kmhTextView.text = "%.2f".format(kmh)
    }
}
