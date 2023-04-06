package com.example.hackathonjudgingtracker.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AirtableNetwork {
    var retrofit: AirtableAPI = Retrofit.Builder()
        .baseUrl("https://api.airtable.com/v0/app0CjTdrLWIfK6sv/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AirtableAPI::class.java)
}