package com.bulich.misha.amberguide.presentations

sealed class Screen(val route: String){
    object CategoryScreen : Screen("category_screen")
    object ItemListScreen : Screen("item_list_screen")
}
