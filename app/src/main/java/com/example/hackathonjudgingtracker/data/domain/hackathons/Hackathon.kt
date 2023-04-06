package com.example.hackathonjudgingtracker.data.domain.hackathons

import com.example.hackathonjudgingtracker.data.domain.projects.ProjectFields

data class Hackathon(
    val id: String,
    val createdTime: String,
    val fields: HackathonFields
)