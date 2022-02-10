package com.example.tryjackpackcompose.entity.inspection

import com.google.gson.annotations.SerializedName

class ChecklistItem {
    @SerializedName("id")
    var id = ""

    @SerializedName("name")
    var name = ""

    @SerializedName("description")
    var description = ""

    @SerializedName("type")
    var type = ""

    @SerializedName("value")
    var value = ""
}