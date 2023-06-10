package com.example.littlelemon.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.littlelemon.domain.model.MenuItem

@Entity(tableName = "menu_items")
data class MenuItemEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String,
)
fun MenuItemEntity.toMenuItem() = MenuItem(title, description, price, image, category)
