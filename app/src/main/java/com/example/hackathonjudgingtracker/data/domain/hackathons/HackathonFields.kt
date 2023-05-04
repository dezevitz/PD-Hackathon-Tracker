package com.example.hackathonjudgingtracker.data.domain.hackathons

import com.google.gson.annotations.SerializedName

data class HackathonFields(
    val Name: String,
    @SerializedName("Projects")
    val ProjectIds: List<String>,
    @SerializedName("Judging Time")
    val judgingTime: Int
)
