package com.example.littlelemon.domain.repository

import com.example.littlelemon.common.Resource
import com.example.littlelemon.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    fun getMenuItems(): Flow<Resource<List<MenuItem>>>
}
