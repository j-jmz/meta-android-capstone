package com.example.littlelemon.data.repository

import androidx.room.withTransaction
import com.example.littlelemon.common.Resource
import com.example.littlelemon.common.networkBoundResource
import com.example.littlelemon.data.database.MenuDatabase
import com.example.littlelemon.data.database.toMenuItem
import com.example.littlelemon.data.remote.MenuApi
import com.example.littlelemon.domain.model.MenuItem
import com.example.littlelemon.domain.repository.MenuRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val menuApi: MenuApi,
    private val db: MenuDatabase
) : MenuRepository {
    private val dao = db.menuItemDao
    override fun getMenuItems(): Flow<Resource<List<MenuItem>>> = networkBoundResource(
        query = { dao.getAll().map { it.map { item -> item.toMenuItem() } } },
        fetch = {
            delay(1000L)
            menuApi.fetchMenu()
        },
        saveFetchedResult = { menuDto ->
            db.withTransaction {
                dao.deleteAll()
                dao.insertAll(*(menuDto.menu
                    .map { it.toMenuItemEntity() }
                    .toTypedArray())
                )
            }
        }
    )
}
