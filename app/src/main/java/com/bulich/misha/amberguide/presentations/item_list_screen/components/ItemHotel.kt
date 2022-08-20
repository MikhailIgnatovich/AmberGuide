package com.bulich.misha.amberguide.presentations.item_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bulich.misha.amberguide.R

@Composable
fun ItemHotel(
    name: String,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .clickable { onItemClick(name) },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.fantastic),
            contentDescription = "Пример",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 260f
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemHotel() {
    ItemHotel(name = "Беккер", onItemClick = {})
}