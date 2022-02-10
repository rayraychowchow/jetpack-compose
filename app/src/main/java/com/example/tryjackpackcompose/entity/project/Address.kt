package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName

class Address {
    @SerializedName("block")
    var block = ""

    @SerializedName("lang")
    var lang = ""

    @SerializedName("floor")
    var floor = ""

    @SerializedName("areaWithin")
    var areaWithin = ""

    @SerializedName("room")
    var room = ""
}