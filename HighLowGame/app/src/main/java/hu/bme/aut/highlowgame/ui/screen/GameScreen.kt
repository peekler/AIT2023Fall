package hu.bme.aut.highlowgame.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.highlowgame.R
import kotlin.random.Random
import androidx.lifecycle.viewmodel.compose.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    viewModel: GameViewModel = viewModel()
) {
    var context = LocalContext.current

    var guessText by rememberSaveable { mutableStateOf("") }
    var restultText by rememberSaveable {
        mutableStateOf(
            context.getString(R.string.text_goodluck)
        )
    }

    var inputErrorState by rememberSaveable {
        mutableStateOf(false)
    }
    var errorText by rememberSaveable {
        mutableStateOf("")
    }


    fun validate(text: String) {
        val allDigits = text.all { char -> char.isDigit() }
        errorText = "This field can be number only"
        inputErrorState = !allDigits
    }
    Column {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            isError = inputErrorState,
            label = { Text(text = stringResource(R.string.text_hint_guess)) },
            value = guessText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            trailingIcon = {
                if (inputErrorState) {
                    Icon(
                        Icons.Filled.Warning, "error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            onValueChange = {
                guessText = it
                validate(guessText)

            })

        if (inputErrorState) {
            Text(
                text = errorText,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = {
                try {
                    val myNum = guessText.toInt()
                    if (myNum == viewModel.randomNum) {
                        // WIN
                        restultText = "You have won!"
                    } else if (myNum < viewModel.randomNum) {
                        //the num is high..
                        restultText = "The number is higher!"
                    } else if (myNum > viewModel.randomNum) {
                        //the num is lower..
                        restultText = "The number is lower!"
                    }

                    inputErrorState = false
                } catch (e: Exception) {
                    inputErrorState = true
                    errorText = e.message!!
                }


            }) {
                Text(text = "Guess")
            }

            Button(onClick = {
                //randomNum = Random(System.currentTimeMillis()).nextInt(3)
                viewModel.generateNewNum()
            }) {
                Text(text = "Restart")
            }
        }



        Text(
            text = restultText,
            fontSize = 28.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        /*Text(
            text = restultText,
            style = TextStyle(
                fontSize = 28.sp,
                shadow = Shadow(
                    color = Color.Blue, offset = Offset(5.0f, 10.0f),
                    blurRadius = 3f
                )
            )
        )*/

    }

}

