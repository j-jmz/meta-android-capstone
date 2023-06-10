package com.example.littlelemon.data.sharedPrefs

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefs @Inject constructor( @ApplicationContext private val context: Context){


    private val prefs: SharedPreferences = context.getSharedPreferences("LittleLemon", MODE_PRIVATE)

    fun putString(key: String, value: String) = prefs.edit().putString(key, value).apply()

    fun getString(key: String, default: String = ""): String = prefs.getString(key, default).orEmpty()

    fun contains(key: String): Boolean = prefs.contains(key)

    fun deleteData() = prefs.edit().clear().apply()

}