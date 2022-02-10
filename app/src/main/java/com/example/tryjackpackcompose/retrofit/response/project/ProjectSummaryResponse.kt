package com.example.tryjackpackcompose.retrofit.response.project

import com.example.tryjackpackcompose.entity.project.ProjectSummary
import com.example.tryjackpackcompose.retrofit.response.ResultResponse
import com.google.gson.annotations.SerializedName

class ProjectSummaryResponse {
    @SerializedName("result")
    var result: ResultResponse = ResultResponse()

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime: String = ""

    @SerializedName("projects")
    var projects: ArrayList<ProjectSummary> = arrayListOf()
}