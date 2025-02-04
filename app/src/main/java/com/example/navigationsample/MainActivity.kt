package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen"){
        composable("firstscreen"){
            FirstScreen {name,age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable(
            route = "secondscreen/{name}/{age}"
        ) {
            val name  = it.arguments?.getString("name")?:"no name"
            val age  = it.arguments?.getString("age")?:"no age"
            SecondScreen (name,age){
                navController.navigate("firstscreen")
            }
        }
        composable(route = "thirdscreen"){
            ThirdScreen{
                navController.navigate("firstscreen")
            }
        }
    }
}
