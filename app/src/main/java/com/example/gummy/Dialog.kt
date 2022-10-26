package com.example.gummy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show)
        AlertDialog(
            title = { Text(text = "Title") },
            text = { Text(text = "I am a description") },
            onDismissRequest = { onDismiss() },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm Button")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss Button")
                }
            }
        )
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show)
        Dialog(
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            ),
            onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .padding(24.dp)
                    .fillMaxWidth()) {
                Text(text = "We require all of your personal data and deep access to your bank account")

                Button(onClick = { onDismiss() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)) {

                    Text(text = "Accept")
                }


                Button(onClick = { onDismiss() }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)) {

                    Text(text = "Cancel")
                }


            }
        }
}