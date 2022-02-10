package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName

class AvailableAddress {
    @SerializedName("createdBy")
    var createBy = ""

    @SerializedName("creationDatetime")
    var creationDatetime = ""

    @SerializedName("lastUpdateBy")
    var lastUpdateBy = ""

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime = ""

    @SerializedName("id")
    var id = ""

    @SerializedName("projectId")
    var projectId = ""

    @SerializedName("referenceLevel")
    var referenceLevel = 0

    @SerializedName("deleted")
    var deleted = false

    @SerializedName("address")
    var address: List<Address> = listOf()
}