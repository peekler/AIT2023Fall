package hu.ait.tictactoe

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.ait.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            binding.ticTacToe.resetGame()
        }
    }

    public fun setMessage(msg: String) {
        binding.tvData.text = msg
    }
}