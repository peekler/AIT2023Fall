package hu.bme.aut.highlowgame.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen() {
    var guessText by remember{mutableStateOf("")}
    var restultText by remember{mutableStateOf("Good luck!")}

    var randomNum = Random(System.currentTimeMillis()).nextInt(3) //[0,1,2]



    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Enter your guess here")},
            value = guessText,
            onValueChange = {
                guessText = it
            })

        Button(onClick = {
            val myNum = guessText.toInt()
            if (myNum == randomNum) {
                // WIN
                restultText = "You have won!"
            } else if (myNum < randomNum) {
                //the num is high..
                restultText = "The number is higher!"
            } else if (myNum > randomNum) {
                //the num is lower..
                restultText = "The number is lower!"
            }


        }) {
            Text(text = "Guess")
        }
        Text(text = restultText,
            fontSize = 28.sp)
    }
    
}