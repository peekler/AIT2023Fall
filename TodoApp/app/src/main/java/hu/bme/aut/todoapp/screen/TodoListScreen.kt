package hu.bme.aut.todoapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoListScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(10.dp)
    ) {

        if (true)
            Text(text = "No items")
        else {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {

            }
        }
    }
}

