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

interface MutableList<T> : List<T>, MutableCollection<T>
public interface List<out E> : Collection<E>

@Composable
fun ShowImage(item: Int, size: Int, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(item),
        contentDescription = null,
        modifier = modifier.height(size.dp)
    )
}

@Composable
fun Flowers(pic: Int, name: String, properName: String, season: String, coins: Int, modifier: Modifier = Modifier) {
    var show by remember { mutableStateOf(false) }
    Column {
        Row {
            ShowImage(item = pic, 50)
            Button(
                onClick = { show = true }, modifier = modifier
                    .height(40.dp)
                    .width(200.dp)
            ) {
                Text(text = name)
            }
        }
        if (show) {
            Text(text = "Scientific name: " + properName)
            Text(text = "Season: " + season)
            Text(text = "Worth " + coins.toString() + " coins")

        }
    }
}



@Preview
@Composable
fun FlowerFactFile(modifier: Modifier = Modifier) {
    val allFlowersChunked = listOf("Alpine Sea Holly", R.drawable.alpine_sea_holly, "Eryngium Alpinum", "Summer", 26,
        "Anthurium", R.drawable.anthurium, "Anthurium Andraeanum", "all seasons", 20).chunked(5)
    val allFlowersName = mutableSetOf<String>()
    //for (flowerSet in allFlowersChunked.indices){
    //    allFlowersName.add(allFlowersChunked[flowerSet].get(0))
    //}
    val flowerInventory = mutableListOf<String>("Alpine Sea Holly", "Anthurium")
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
    }
}
