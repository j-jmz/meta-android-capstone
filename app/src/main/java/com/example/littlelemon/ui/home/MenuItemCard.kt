package com.example.littlelemon.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.R
import com.example.littlelemon.domain.model.MenuItem
import com.example.littlelemon.ui.theme.MyApplicationTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItemCard(item: MenuItem) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.70f)
            ) {
                Text(
                    text = item.title,
//                    color = colorResource(id = R.color.littlelemon_yellow),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.karla_regular, FontWeight.Normal)),
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = item.description,
                    color = colorResource(id = R.color.littlelemon_grey),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 1.em,
                    fontFamily = FontFamily(Font(R.font.karla_regular, FontWeight.Normal)),
                    textAlign = TextAlign.Left,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "$${item.price}",
                    color = colorResource(id = R.color.littlelemon_grey),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.karla_regular, FontWeight.Normal)),
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
            GlideImage(
                model = item.image,
                contentDescription = "Dish Image",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                it.error(R.drawable.image_placeholder)
                    .placeholder(R.drawable.image_placeholder)
                    .load(item.image)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuItemPreview() {
    MyApplicationTheme {
        MenuItemCard(
            MenuItem(
                "title",
                "description",
                "$12.99",
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Orm5t6ckVRx5GYbGi2GpZwHaE7%26pid%3DApi&f=1&ipt=39275dfa4c4f1dfe363fe6d1ca424be60506d30947b985d36066c1b999d7c7a0&ipo=images",
                "category"
            )
        )
    }
}