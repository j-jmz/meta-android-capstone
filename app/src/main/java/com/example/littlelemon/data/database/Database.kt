package com.example.littlelemon.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MenuItemEntity::class], version = 1)
abstract class MenuDatabase : RoomDatabase() {
    abstract val menuItemDao: MenuItemDao
}
