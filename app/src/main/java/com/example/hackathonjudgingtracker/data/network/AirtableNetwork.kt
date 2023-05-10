package com.example.hackathonjudgingtracker.data.network

import com.example.hackathonjudgingtracker.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AirtableNetwork {
    private val client = OkHttpClient.Builder().addInterceptor(Interceptor {
        val request = it.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer ${BuildConfig.AIRTABLE_PAT}")
            .build()
        return@Interceptor it.proceed(request)
    }).build()

    val retrofit: AirtableAPI = Retrofit.Builder()
        .baseUrl("https://api.airtable.com/v0/app0CjTdrLWIfK6sv/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(AirtableAPI::class.java)
}