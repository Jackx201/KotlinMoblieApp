package com.example.gummy

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Column() {
                        var selected by rememberSaveable {
                            mutableStateOf("")
                        }
                        myRadioButtonList(selected){selected=it}
                    }
                }
            }
        }
    }
}

@Composable
fun myRadioButtonList(selected: String, onItemSelected:(String)->Unit){

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected=="Michelle",
            onClick = { onItemSelected("Michelle") })
        Text(text = "Michelle")
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected=="Natalia",
            onClick = { onItemSelected("Natalia") })
        Text(text = "Natalia")
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected=="Luna",
            onClick = { onItemSelected("Luna") })
        Text(text = "Luna")
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMyBox() {
    GummyTheme {
        Column() {
            //myRadioButtonList()
        }
    }
}