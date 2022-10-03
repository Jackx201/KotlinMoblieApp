package com.example.gummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                    //myBox()
                    //myColumn()
                    //myRow()
                    myComplexLayout()
                }
            }
        }
    }
}

@Composable
fun myBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(color = Color.Magenta)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center
        ) {
            Text(text = "I am a box")
        }
    }
}

@Composable
fun myColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "I am the column 1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 2",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 3",
            Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 4",
            Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 4",
            Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 1",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 2",
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 3",
            Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "I am the column 4",
            Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun myRow() {

    Row(Modifier.horizontalScroll(rememberScrollState())) {
        Text(
            text = "I am the column 1",
            Modifier
                .background(Color.Red)
                .height(50.dp)
        )
        Text(
            text = "I am the column 2",
            Modifier
                .background(Color.Blue)
                .height(50.dp)
        )
        Text(
            text = "I am the column 3",
            Modifier
                .background(Color.Green)
                .height(50.dp)
        )
        Text(
            text = "I am the column 4",
            Modifier
                .background(Color.Gray)
                .height(50.dp)
        )
        Text(
            text = "I am the column 1",
            Modifier
                .background(Color.Red)
                .height(50.dp)
        )
        Text(
            text = "I am the column 2",
            Modifier
                .background(Color.Blue)
                .height(50.dp)
        )
        Text(
            text = "I am the column 3",
            Modifier
                .background(Color.Green)
                .height(50.dp)
        )
        Text(
            text = "I am the column 4",
            Modifier
                .background(Color.Gray)
                .height(50.dp)
        )
    }
}

@Composable
fun myComplexLayout() {
    Column() {
        Box(
            Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(text = "I am a box")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .weight(1f)
                .fillMaxHeight()) {
                Text(text = "I am a CYAN box")
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .weight(1f)
                .fillMaxHeight()) {
                Text(text = "I am a BLUE box")
            }
        }
        Box(Modifier.background(Color.Yellow).weight(1f).fillMaxHeight().fillMaxWidth()) {
            Text(text = "I am a yellow box")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMyBox() {
    GummyTheme {
        //myBox()
        //myColumn()
        //myRow()
        myComplexLayout()
    }
}