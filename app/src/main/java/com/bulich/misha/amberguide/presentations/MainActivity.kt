package com.bulich.misha.amberguide.presentations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bulich.misha.amberguide.presentations.category_screen.CategoryScreen
import com.bulich.misha.amberguide.presentations.item_list_screen.ItemListScreen
import com.bulich.misha.amberguide.presentations.ui.theme.AmberGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmberGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CategoryScreen.route
                    ) {
                        composable(
                            route = Screen.CategoryScreen.route
                        ){
                            CategoryScreen(navController)
                        }
                        composable(
                            route = Screen.ItemListScreen.route + "/{category}"
                        ){
                            ItemListScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AmberGuideTheme {
        Greeting("Android")
    }
}