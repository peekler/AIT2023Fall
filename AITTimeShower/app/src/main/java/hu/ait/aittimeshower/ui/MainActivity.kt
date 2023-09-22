package hu.ait.aittimeshower.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import hu.ait.aittimeshower.R
import hu.ait.aittimeshower.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val UI_LOG_TAG = "TAG_UI"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTime.setOnClickListener {
            Log.d(UI_LOG_TAG,"btnTime was pressed")



            Toast.makeText(this,
                "Hello ${binding.etUser.text.toString()}", Toast.LENGTH_LONG).show()

            Snackbar.make(binding.root, "Hello ${binding.etUser.text.toString()}",
                Snackbar.LENGTH_LONG).setAction("Undo", {
                    // do something when undo pressed
                }).show()

            binding.tvTime.text =
                getString(R.string.hello_the_time_is, Date(System.currentTimeMillis()).toString())
            revealCard()
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun revealCard() {
        Log.d(UI_LOG_TAG,"animation start")

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