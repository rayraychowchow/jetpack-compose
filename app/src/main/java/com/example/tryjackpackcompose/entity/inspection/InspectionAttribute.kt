package com.example.tryjackpackcompose.entity.inspection

import com.google.gson.annotations.SerializedName

class InspectionAttribute {
    @SerializedName("length")
    var length = 0.0

    @SerializedName("width")
    var width = 0.0

    @SerializedName("qty")
    var qty = 0

    @SerializedName("priority")
    var priority: String = ""

    @SerializedName("note")
    var note: String = ""

    @SerializedName("currentStatus")
    var currentStatus = 0

    @SerializedName("completedPercentage")
    var completedPercentage = 0

    @SerializedName("completed")
    var completed = false

    @SerializedName("immediateDanger")
    var immediateDanger = 0

    @SerializedName("otherDisplayName")
    var otherDisplayName: String = ""

    @SerializedName("progressionAffected")
    var progressionAffected = false
}