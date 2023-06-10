package com.example.littlelemon.data.repository

import com.example.littlelemon.data.sharedPrefs.SharedPrefs
import com.example.littlelemon.domain.repository.SharedPrefsRepository
import javax.inject.Inject

class SharedPrefsRepositoryImpl @Inject constructor(
    private val sharedPrefs: SharedPrefs
) : SharedPrefsRepository {

    override fun putString(key: String, value: String) = sharedPrefs.putString(key, value)

    override fun getString(key: String, default: String): String =
        sharedPrefs.getString(key, default)

    override fun contains(key: String): Boolean = sharedPrefs.contains(key)

    override fun deleteData() = sharedPrefs.deleteData()
}