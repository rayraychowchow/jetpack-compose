package com.example.tryjackpackcompose.retrofit.response.project

import com.example.tryjackpackcompose.entity.project.ProjectDetail
import com.example.tryjackpackcompose.retrofit.response.ResultResponse
import com.google.gson.annotations.SerializedName

class ProjectDetailResponse {
    @SerializedName("result")
    var result: ResultResponse = ResultResponse()

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime: String = ""

    @SerializedName("Project")
    var project: ProjectDetail = ProjectDetail()
}