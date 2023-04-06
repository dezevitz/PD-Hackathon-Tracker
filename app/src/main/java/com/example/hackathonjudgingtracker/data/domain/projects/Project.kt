package com.example.hackathonjudgingtracker.data.domain.projects

import com.example.hackathonjudgingtracker.data.domain.projects.ProjectFields

data class Project(
    val id: String,
    val createdTime: String,
    val fields: ProjectFields
)