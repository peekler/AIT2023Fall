package hu.bme.aut.layoutinflaterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.layoutinflaterdemo.databinding.ActivityMainBinding
import hu.bme.aut.layoutinflaterdemo.databinding.TodoRowBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        val todoBindig = TodoRowBinding.inflate(layoutInflater)

        todoBindig.tvTodo.text = binding.etTodo.text.toString()
        todoBindig.btnDelete.setOnClickListener {
            binding.layoutContent.removeView(todoBindig.root)
        }

        binding.layoutContent.addView(todoBindig.root,0)
    }
}