package com.example.littlelemon.di

import com.example.littlelemon.data.repository.MenuRepositoryImpl
import com.example.littlelemon.data.repository.SharedPrefsRepositoryImpl
import com.example.littlelemon.domain.repository.MenuRepository
import com.example.littlelemon.domain.repository.SharedPrefsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsMenuRepo(
        menuRepositoryImpl: MenuRepositoryImpl
    ): MenuRepository

    @Binds
    @Singleton
    abstract fun bindsSharedPreferencesRepository(
        sharedPrefsRepositoryImpl: SharedPrefsRepositoryImpl
    ): SharedPrefsRepository
}
