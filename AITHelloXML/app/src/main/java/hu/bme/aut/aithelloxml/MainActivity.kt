package hu.bme.aut.aithelloxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowTime = findViewById<Button>(R.id.btnTime)
        val tvTime = findViewById<TextView>(R.id.tvTime)
        btnShowTime.setOnClickListener {
            tvTime.text="${Date(System.currentTimeMillis()).toString()}"
        }
    }
}