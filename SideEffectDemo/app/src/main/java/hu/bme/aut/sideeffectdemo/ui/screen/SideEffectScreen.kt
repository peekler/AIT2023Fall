package hu.bme.aut.sideeffectdemo.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun SideEffectScreen() {
    var counter = remember { mutableStateOf(0) }
    val context = LocalContext.current

    /*SideEffect {
        Toast.makeText(context,
            "SideEffect - recompose", Toast.LENGTH_SHORT).show()
    }*/

    LaunchedEffect(key1 = Unit) {
        Toast.makeText(context,
            "LAUNCH", Toast.LENGTH_SHORT).show()
    }

    DisposableEffect(key1 = Unit) {

        onDispose {
            Toast.makeText(context,
                "DISPOSE", Toast.LENGTH_SHORT).show()
        }
    }

    Column {
        Text(text = "${counter.value}")
        Button(onClick = {
            counter.value++
        }) {
            Text(text = "Increase counter")
        }
    }

}