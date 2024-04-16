package com.example.technovation2

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import java.net.PasswordAuthentication

//streaks button says what number day streak you have - if pressed then if says 'you have a (something) day streak'
//user should be able to input a username


@Composable
fun StreaksButton(numDays: Int, modifier: Modifier = Modifier){
    var show by remember{mutableStateOf(false)}
    Column(modifier = modifier.horizontalScroll(rememberScrollState())){
        Button(onClick = {show = true}, modifier = modifier
            .height(50.dp)
            .width(400.dp)) {
            //Text(text = numDays.toString())
            for (i in 1..numDays){
                Image(
                    painter = painterResource(R.drawable.tree),
                    contentDescription = null,
                    modifier = modifier.width(20.dp)
                )
            }
        }
        if (show){
            Text("you have a " + numDays.toString() + " day streak")
        }
        else{
            Text("press the trees")
        }
    }
}

@Composable
fun ShowStreaksButton(){
    StreaksButton(numDays = 5)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameInput() {
    var userClick by remember { mutableStateOf(false) }
    Button(onClick = { userClick = true }) {
        Text(text = "username")
    }
    if (userClick) {
        var username by remember { mutableStateOf("enter your username here") }
        TextField(value = username, onValueChange = { username = it })
        var enterClick by remember {mutableStateOf(false)}
        Button(onClick = {enterClick = true}) {
            Text(text = "enter")
        }
        if (enterClick){
            Text(text = "your username is " + username)
        }
    }
}


@Preview
@Composable
fun Profile(){
    Column {
        ShowStreaksButton()
        Text(text = "enter your username")
        UsernameInput()

    }
}