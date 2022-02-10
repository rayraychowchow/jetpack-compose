package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName

class Landmark {
    @SerializedName("id")
    var id = ""

    @SerializedName("uuid")
    var uuid = ""

    @SerializedName("projectId")
    var projectId = ""

    @SerializedName("batteryStatus")
    var batteryStatus = ""

    @SerializedName("rfPower")
    var rfPower = ""

    @SerializedName("availableAddressId")
    var availableAddressId = ""

    @SerializedName("activationDate")
    var activationDate = ""

    @SerializedName("activationUsername")
    var activationUsername = ""

    @SerializedName("addressAssignDate")
    var addressAssignDate = ""

    @SerializedName("addressAssignUsername")
    var addressAssignUsername = ""

    @SerializedName("batteryLastUpdateTime")
    var batteryLastUpdateTime = ""

    @SerializedName("validationCode")
    var validationCode = ""

    @SerializedName("lowBatLevel")
    var lowBatLevel: Any? = null

    @SerializedName("status")
    var status = ""

    @SerializedName("createBy")
    var createBy = ""

    @SerializedName("creationDateTime")
    var creationDateTime = ""

    @SerializedName("lastUpdateBy")
    var lastUpdateBy = ""

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime = ""

    @SerializedName("deleted")
    var deleted = false
}