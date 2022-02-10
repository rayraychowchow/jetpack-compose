package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName

class Circulation {
    @SerializedName("_id")
    var id = ""

    @SerializedName("tradeId")
    var tradeId = ""

    @SerializedName("tradeName")
    var tradeName = ""

    @SerializedName("personInChargeEmail")
    var personInChargeEmail = ""

    @SerializedName("groups")
    var groups: List<CirculationGroup> = listOf()
}

class CirculationGroup {
    @SerializedName("divisionId")
    var divisionId = ""

    @SerializedName("divisionName")
    var divisionName = ""

    @SerializedName("members")
    var members: List<String> = listOf()
}