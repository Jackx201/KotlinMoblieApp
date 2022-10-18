package com.example.gummy

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
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
import com.example.gummy.ui.theme.Shapes

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
                    Column {
                        var selected by rememberSaveable {
                            mutableStateOf("")
                        }
                        myBadgeBox()

                    }
                }
            }
        }
    }
}

@Composable
fun myBadgeBox(){
    BadgedBox(badge = { Badge{ Text(text = "7")}},
    modifier = Modifier.padding(10.dp)) {
        Icon(imageVector = Icons.Filled.Favorite,
            contentDescription = "Notifications" )
    }

    BadgedBox(badge = { Badge(backgroundColor = Color.Green, contentColor = Color.Magenta){ Text(text = "7")}},
        modifier = Modifier.padding(10.dp)) {
        Icon(imageVector = Icons.Filled.Email,
            contentDescription = "Messages" )
    }

    BadgedBox(badge = { Badge{ Text(text = "!")}},
        modifier = Modifier.padding(10.dp)) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "New Post")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMyBox() {
    GummyTheme {
        Column {
            myBadgeBox()
        }
    }
}