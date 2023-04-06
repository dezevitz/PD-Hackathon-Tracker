package com.example.hackathonjudgingtracker.data.network

import com.example.hackathonjudgingtracker.BuildConfig
import com.example.hackathonjudgingtracker.data.domain.hackathons.HackathonRecords
import com.example.hackathonjudgingtracker.data.domain.judges.JudgeRecords
import com.example.hackathonjudgingtracker.data.domain.projects.ProjectRecords
import retrofit2.http.GET
import retrofit2.http.Header

interface AirtableAPI {
    @GET("tbl4qe3bDy8LZNxEk")
    suspend fun getProjects(
        @Header("Authorization") authorization: String = "Bearer ${BuildConfig.AIRTABLE_PAT}"
    ): ProjectRecords

    @GET("tblEnmYBQnPOZpy1d")
    suspend fun getHackathon(
        @Header("Authorization") authorization: String = "Bearer ${BuildConfig.AIRTABLE_PAT}"
    ): HackathonRecords

    @GET("tbl9cfvyw8GK8MBRi")
    suspend fun getJudges(
        @Header("Authorization") authorization: String = "Bearer ${BuildConfig.AIRTABLE_PAT}"
    ): JudgeRecords
}