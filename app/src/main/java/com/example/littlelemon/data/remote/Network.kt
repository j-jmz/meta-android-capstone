package com.example.littlelemon.data.remote

import com.example.littlelemon.data.database.MenuItemEntity
import kotlinx.serialization.Serializable

@Serializable
data class MenuDto(
    val menu: List<MenuItemDto>
) {
    @Serializable
    data class MenuItemDto(
        val id: Int,
        val title: String,
        val description: String,
        val price: String,
        val image: String,
        val category: String,
    ) {
        fun toMenuItemEntity() = MenuItemEntity(
            id,
            title,
            description,
            price,
            image,
            category,
        )
    }
}