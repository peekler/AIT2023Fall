package hu.bme.aut.composehelloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import hu.bme.aut.composehelloworld.ui.screen.TimeShowScreen
import hu.bme.aut.composehelloworld.ui.theme.ComposeHelloWorldTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeHelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /*Column {
                        Greeting("Android")
                        TimeShowScreen()
                    }*/


                    TimeShowScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello AIT $name!",
            modifier = modifier,
            fontSize = 30.sp
        )

        Text(
            text = "DEMO TEXT",
            fontSize = 20.sp
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeHelloWorldTheme {
        Greeting("Android")
    }
}