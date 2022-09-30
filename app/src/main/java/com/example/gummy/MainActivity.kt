package com.example.gummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                    Greeting("Zahúl Domínguez")
                }
            }
        }
    }
}

@Composable
fun sayHello(textTobeDisplayed: String) {
    Text(
        text = textTobeDisplayed,
        modifier = Modifier
            .height(200.dp)
            .width(100.dp)
            .padding(10.dp)
            .clickable { })
}

@Preview(
    showBackground = true,
    name = "Test with Oreo",
    showSystemUi = true,
    device = Devices.NEXUS_6
)
@Composable
fun HelpSayHello() {
    sayHello("Hello World")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GummyTheme {
        Greeting("Android")
    }
}