package hu.bme.aut.sideeffectdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.bme.aut.sideeffectdemo.ui.screen.SideEffectScreen
import hu.bme.aut.sideeffectdemo.ui.theme.SideEffectDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffectDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //SideEffectScreen()
                    DisposeDemo()
                }
            }
        }
    }
}

@Composable
fun DisposeDemo() {
    var isVisible by remember { mutableStateOf(true) }

    Column {
        Button(onClick = {
            isVisible = !isVisible
        }) {
            if (isVisible) {
                Text(text = stringResource(R.string.button_hide))
            } else {
                Text(text = "Show")
            }
        }

        if (isVisible) {
            SideEffectScreen()
        }
    }
}
