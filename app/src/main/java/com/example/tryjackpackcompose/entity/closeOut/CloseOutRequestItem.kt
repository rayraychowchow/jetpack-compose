package com.example.tryjackpackcompose.entity.closeOut

import com.example.tryjackpackcompose.entity.image.ImageThumbnail
import com.google.gson.annotations.SerializedName

class CloseOutRequestItem {
    @SerializedName("requestedTime")
    var requestedTime = ""

    @SerializedName("newStatus")
    var newStatus = ""

    @SerializedName("user")
    var user = ""

    @SerializedName("id")
    var id = ""

    @SerializedName("imageThumbnail")
    var imageThumbnail: List<ImageThumbnail> = listOf()
}