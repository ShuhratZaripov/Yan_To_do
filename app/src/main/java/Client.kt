//package com.example.yan_to_do.network
//
//import android.content.Context
//import okhttp3.Cache
//import okhttp3.OkHttpClient
//import java.io.File
//import java.util.concurrent.TimeUnit
//
//object NetworkClient {
//
//    fun getHttpClient(context: Context): OkHttpClient {
//        val cacheSize: Long = 48 * 1024 * 1024 // 48 MB
//        val cacheDir = File(context.cacheDir, "http_cache")
//        val cache = Cache(cacheDir, cacheSize)
//
//        return OkHttpClient.Builder()
//            .connectTimeout(10, TimeUnit.SECONDS)
//            .readTimeout(10, TimeUnit.SECONDS)
//            .writeTimeout(10, TimeUnit.SECONDS)
//            .cache(cache)
//            .build()
//    }
//}
