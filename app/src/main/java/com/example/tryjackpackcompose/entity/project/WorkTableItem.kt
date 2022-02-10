package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName

class WorkTableItem {
    @SerializedName("code")
    var code = ""
    @SerializedName("currentLevel")
    var currentLevel = 0
    @SerializedName("parentId")
    var parentId = ""
    @SerializedName("eng")
    var eng = ""
    @SerializedName("zht")
    var zht = ""
    @SerializedName("length")
    var length = false
    @SerializedName("width")
    var width = false
    @SerializedName("qty")
    var qty = false
    @SerializedName("priority")
    var priority = false
    @SerializedName("note")
    var note = false
    @SerializedName("progressionAffected")
    var progressionAffected = false
    @SerializedName("currentStatus")
    var currentStatus = false
    @SerializedName("immediateDanger")
    var immediateDanger = false
    @SerializedName("isOther")
    var isOther = false
    @SerializedName("completed")
    var completed = false
    @SerializedName("completedPercentage")
    var completedPercentage = false
    @SerializedName("progression")
    var progression = false
    @SerializedName("status")
    var status = false
    @SerializedName("nonDefect")
    var nonDefect = false
    @SerializedName("prefix")
    var prefix = ""
    @SerializedName("id")
    var id = ""
    @SerializedName("projectId")
    var projectId = ""
    @SerializedName("colorCodeStart")
    var colorCodeStart = ""
    @SerializedName("colorCodeEnd")
    var colorCodeEnd = ""
    @SerializedName("createBy")
    var createBy = ""
    @SerializedName("creationDatetime")
    var creationDatetime = ""
    @SerializedName("lastUpdateBy")
    var lastUpdateBy = ""
    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime = ""
    @SerializedName("deleted")
    var deleted = false
}