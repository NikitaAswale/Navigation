package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name:String, age:String, navigateToFirstScreen: () -> Unit){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("This is the Second screen", fontSize = 20.sp, color = Color.Red)
        Text("Hello $age year old $name", fontSize = 18.sp)

        Button(onClick = {
            navigateToFirstScreen()
        })
        {
            Text("Go to First Screen")
        }
        /*Button(onClick = {
            navigateToThirdScreen()
        })
        {
            Text("Go to Third Screen")
        }*/
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen(
        "Nikita", 24.toString(),
        navigateToFirstScreen = TODO()
    )
}