package com.bulich.misha.amberguide.presentations.category_screen


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bulich.misha.amberguide.R
import com.bulich.misha.amberguide.presentations.Screen
import com.bulich.misha.amberguide.presentations.category_screen.components.CategoryCard

@Composable
fun CategoryScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryCard(
            name = "Гостиницы",
            painter = painterResource(id = R.drawable.hotel_24),
            onItemClick = {
                navController.navigate(Screen.ItemListScreen.route + "/{Гостиницы}")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CategoryCard(
            name = "Рестораны",
            painter = painterResource(id = R.drawable.hotel_24),
            onItemClick = {
                navController.navigate(Screen.ItemListScreen.route + "/{Рестораны}")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CategoryCard(
            name = "Интересное",
            painter = painterResource(id = R.drawable.hotel_24),
            onItemClick = {
                navController.navigate(Screen.ItemListScreen.route + "/{Интересное}")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    CategoryScreen(rememberNavController())
}