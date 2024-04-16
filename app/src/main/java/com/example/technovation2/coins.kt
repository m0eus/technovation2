package com.example.technovation2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.technovation2.ui.theme.Technovation2Theme

//shows how many coins (currenly set to 50)
//should show a coin picture

var numCoins: Int = 50
var inventory = mutableListOf<String>()

@Composable
fun NumCoin(numCoins: Int, modifier: Modifier = Modifier) {
    Text(
        text = "You have " + numCoins.toString() + " coins",
        modifier = modifier.background(color = Color.LightGray)
    )
}


@Composable
fun ShowNumCoin() {
    Technovation2Theme {
        NumCoin(numCoins, Modifier)
    }
}

@Composable
fun Images(modifier: Modifier = Modifier, item: Int, size: Int){
    Image(
        painter = painterResource(item),
        contentDescription = null,
        modifier = modifier.width(size.dp)
    )
}

@Composable
fun Words(words: String, modifier: Modifier = Modifier){
    Text(
        text = words
    )
}


@Composable
fun ShowShop(modifier: Modifier = Modifier){

    Column(modifier = modifier.verticalScroll(rememberScrollState())){
        Words(words = "Gardening tools")
        Row{
            Words(words = "")
        }
        Row {
            Images(item = R.drawable.shovel, size = 25)
            Words(words = "Shovel")
        }
        Row{
            Images(item = R.drawable.wateringcan, size = 25)
            Words(words = "Watering can")
        }
        Row{
            Images(item = R.drawable.nutrients, size = 25)
            Words(words = "Nutrition")
        }
    }
}

//fun buyStuff(cost: Int, numCoins: Int){
    //numCoins -= cost


//}

@Preview
@Composable
fun Coins(){
    Column{
        ShowNumCoin()
        ShowShop()
    }
}