package com.example.gummy

import android.accounts.Account
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

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
                    .fillMaxWidth()
            ) {
                Text(text = "We require all of your personal data and deep access to your bank account")

                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
                ) {

                    Text(text = "Accept")
                }


                Button(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                ) {

                    Text(text = "Cancel")
                }

            }
        }
}

@Composable
fun AdvancedDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show)
        Dialog(onDismissRequest = { onDismiss() }) {
            Surface(shape = RoundedCornerShape(10.dp)) {
                Column(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTitleDialog("Example from a function")
                }
            }
        }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { Log.i("Email", email) }) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}

@Composable
fun MyCustomAlertDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show)
        Dialog(onDismissRequest = { onDismiss() }) {
            Surface(shape = RoundedCornerShape(8.dp)) {
                Column(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyTitleDialog(text = "List of Clients")

                    Divider(Modifier.fillMaxWidth(), color = Color.Black)

                    for (i in 1..3) {
                        AccountItem(email = "email@gmail.com", drawable = R.drawable.test)
                    }

                    Divider(Modifier.fillMaxWidth(), color = Color.Black)
                }
            }
        }
}


@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show)
    Dialog(onDismissRequest = { onDismiss() }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)) {
            MyTitleDialog(text = "Select an Option")
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)
            var status by remember {
                mutableStateOf("")
            }
            myRadioButtonList(selected =status ){ status = it }
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.LightGray)

            Row(modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp)) {

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Cancel")
                }

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Ok")
                }
            }
        }
    }   
}