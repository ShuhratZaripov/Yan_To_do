package com.example.yan_to_do.network

import android.content.Context

interface TokenProvider {
    fun getToken(): String
}

class SharedPrefsTokenProvider(private val context: Context) : TokenProvider {
    override fun getToken(): String {
        val sharedPreferences = context.getSharedPreferences("auth", Context.MODE_PRIVATE)
        return sharedPreferences.getString("token", "Celeborn") ?: "Celeborn"
    }
}