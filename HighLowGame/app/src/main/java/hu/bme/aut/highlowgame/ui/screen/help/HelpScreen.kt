package hu.bme.aut.highlowgame.ui.screen.help


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HelpScreen(
    modifier: Modifier = Modifier,
    helpText: String
) {
    Column() {
        Text(text = helpText)
    }
}