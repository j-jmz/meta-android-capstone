package com.example.littlelemon.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.littlelemon.data.database.MenuDatabase
import com.example.littlelemon.data.sharedPrefs.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMenuItemDatabase(app: Application): MenuDatabase =
        Room.databaseBuilder(app, MenuDatabase::class.java, name = "app_db").build()

    @Provides
    @Singleton
    fun providesHttpClient(): HttpClient =
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(contentType = ContentType("text", "plain"))
            }
        }

    @Provides
    @Singleton
    fun providesSharedPreferences(@ApplicationContext context: Context): SharedPrefs =
        SharedPrefs(context)
}
