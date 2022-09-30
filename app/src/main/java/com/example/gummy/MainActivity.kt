package com.example.gummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gummy.ui.theme.GummyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GummyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    myBox()
                }
            }
        }
    }
}

@Composable
fun myBox() {
    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()) {
        Box(modifier = Modifier
            //.width(100.dp)
            .height(100.dp)
            .background(color = Color.Magenta)
            .verticalScroll(rememberScrollState())) {
            Text(text = "Hello I am a box")
            Text(text = "Hello I am a box")
            Text(text = "Hello I am a box")
            Text(text = "Hello I am a box")
            Text(text = "Hello I am a box")

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMyBox() {
    GummyTheme {
        myBox()
    }
}