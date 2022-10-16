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
                    /*Column() {
                        val options = getOptions(listOf(
                            "Michelle",
                            "Natalia",
                            "Allison",
                            "Ashley",
                            "Jessica"))
                        options.forEach{
                            myCheckBoxChecked(it)
                        }
                    }*/
                    //myToDoList()
                    myRadioButton()
                }
            }
        }
    }
}

@Composable
fun myRadioButton(){
    var status by rememberSaveable {
        mutableStateOf(false)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = status,
            onClick = { status = !status },
            enabled = true,
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Cyan,
            unselectedColor = Color.LightGray,
            disabledColor = Color.Red
        )
            )
        Text(text = "Radio Button #1")
    }
}

@Composable
fun getOptions(title: List<String>): List<CheckInfo> {
    return title.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun myCheckBoxChecked(checkInfo: CheckInfo) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Text(text = checkInfo.title)
    }
}

@Composable
fun myToDoList() {
    var checkedState by rememberSaveable {
        mutableStateOf(false)
    }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checkedState, onCheckedChange = { checkedState = !checkedState })
            Text(text = "CheckBox #1")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultMyBox() {
    GummyTheme {
        //myToDoList()
        myRadioButton()
    }
}