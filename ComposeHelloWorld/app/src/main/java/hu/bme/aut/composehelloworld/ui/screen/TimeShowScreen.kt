package hu.bme.aut.composehelloworld.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import hu.bme.aut.composehelloworld.ui.theme.ComposeHelloWorldTheme
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeShowScreen() {
    var timeText by rememberSaveable { mutableStateOf("NAN") }
    var nameText by rememberSaveable { mutableStateOf("") }

    Column {
        Text(text = "DateTime: $timeText $nameText", fontSize = 30.sp)
        
        Button(onClick = {
            timeText = Date(System.currentTimeMillis()).toString()
        }) {
            Text(text = "Show time")
        }

        OutlinedTextField(
            label = {Text(text = "Enter name here")},
            value = "$nameText",
            onValueChange = {
                nameText = it
            })
    }
}


@Preview(showBackground = true)
@Composable
fun TimeScreenPreview() {
    ComposeHelloWorldTheme {
        TimeShowScreen()
    }
}