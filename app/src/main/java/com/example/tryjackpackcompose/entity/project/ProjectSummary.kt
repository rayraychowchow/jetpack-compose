package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName
class ProjectSummary {
    @SerializedName("title")
    var title: Map<String, Any>? = null

    @SerializedName("address")
    var address: Map<String, Any>? = null

    @SerializedName("id")
    var id: String = ""

    @SerializedName("creationDatetime")
    var creationDatetime: String = ""

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime: String = ""

    @SerializedName("deleted")
    var deleted: Boolean = false
}