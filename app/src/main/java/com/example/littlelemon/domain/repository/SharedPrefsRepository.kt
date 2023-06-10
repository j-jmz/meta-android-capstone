package com.example.littlelemon.domain.repository

interface SharedPrefsRepository {

    fun putString(key: String, value: String)

    fun getString(key: String, default: String = ""): String

    fun contains(key: String): Boolean

    fun deleteData()
}