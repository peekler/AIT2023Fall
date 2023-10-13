package hu.bme.aut.highlowgame.ui.view

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun SimpleAlertDialog(
    title: String,
    body: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = { Text(text = body) },
        confirmButton = {
            TextButton(onClick = onConfirm)
            { Text(text = "OK") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss)
            { Text(text = "Cancel") }
        }
    )
}
