package com.example.hackathonjudgingtracker.data.domain.projects

import com.google.gson.annotations.SerializedName

data class ProjectFields(
    val Name: String,
    @SerializedName("Prize Categories")
    val PrizeCategories: List<String>
)
