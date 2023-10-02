package hu.bme.aut.multiactivitydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.multiactivitydemo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // read the received KEY_DATA parameter
        if (intent.hasExtra(MainActivity.KEY_DATA)) {
            val data = intent.getStringExtra(MainActivity.KEY_DATA)
            binding.tvData.text = data
        }
    }
}