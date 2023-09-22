package hu.bme.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.simplecalculator.databinding.ActivityMainBinding
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    fun setupWeekendMode(mode: Boolean) {
        if (mode) {
            // turn on alarm
            // turn on cameras...
        } else {
            // turn off alarm
            // turn on doors
        }
    }

    fun enableWeekendMode() {
        // turn on alarm
        // turn on cameras...
    }

    fun disableWeekendMode() {
        // turn off alarm
        // turn on doors
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var name: String? = null
        val length = name?.length ?: -1
        binding.tvResult.text = "$length"




        binding.btnPlus.setOnClickListener {
            try {
                if (binding.etNumA.text.isEmpty()) {
                    binding.etNumA.error = "This field can not be empty"
                } else if (binding.etNumB.text.isEmpty()) {
                    binding.etNumB.error = "This field can not be empty"
                } else {
                    val numA = binding.etNumA.text.toString().toInt()
                    val numB = binding.etNumB.text.toString().toInt()

                    binding.tvResult.text = "${numA + numB}"
                }
            } catch (e: Exception) {
                binding.tvResult.text = "Error: ${e.message}"
            }
        }
    }

}