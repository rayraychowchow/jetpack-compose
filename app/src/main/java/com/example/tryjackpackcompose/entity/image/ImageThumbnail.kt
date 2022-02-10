package com.example.tryjackpackcompose.entity.image

import com.google.gson.annotations.SerializedName

class ImageThumbnail {
    @SerializedName("id")
    var id = ""

    @SerializedName("inspectionItemId")
    var inspectionItemId = ""

    @SerializedName("data")
    var data = ""

    @SerializedName("order")
    var order = 0

    @SerializedName("followUpIndex")
    var followUpIndex = 0

    @SerializedName("deleted")
    var deleted = false

    @SerializedName("createBy")
    var createBy = ""

    @SerializedName("creationDatetime")
    var creationDatetime = ""

    @SerializedName("lastUpdateBy")
    var lastUpdateBy = ""

    @SerializedName("lastUpdateDatetime")
    var lastUpdateDatetime = ""
}