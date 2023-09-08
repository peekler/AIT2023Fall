package hu.ait.aittimeshower.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import hu.ait.aittimeshower.R
import hu.ait.aittimeshower.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTime.setOnClickListener {
            //binding.tvTime.text = "${Date(System.currentTimeMillis()).toString()}"
            //revealCard()

            var numA = binding.etNumA.text.toString().toInt()
            var numB = binding.etNumB.text.toString().toInt()
            binding.tvTime.text = "${numA+numB}"

        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun revealCard() {
        val x = binding.cardView.getRight()
        val y = binding.cardView.getBottom()

        val startRadius = 0
        val endRadius = Math.hypot(binding.cardView.getWidth().toDouble(),
            binding.cardView.getHeight().toDouble()).toInt()

        val anim = ViewAnimationUtils.createCircularReveal(
            binding.cardView,
            x,
            y,
            startRadius.toFloat(),
            endRadius.toFloat()
        )

        binding.cardView.setVisibility(View.VISIBLE)
        //anim.duration = 5000
        anim.start()
    }

}