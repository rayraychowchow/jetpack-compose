package com.example.tryjackpackcompose.entity.project

import com.google.gson.annotations.SerializedName

class Division {
    @SerializedName("id")
    var id = ""

    @SerializedName("name")
    var name = ""

    @SerializedName("internalMembers")
    var internalMembers: List<DivisionMember> = listOf()

    @SerializedName("externalMembers")
    var externalMembers: List<DivisionMember> = listOf()
}

class DivisionMember {
    @SerializedName("email")
    var email = ""

    @SerializedName("displayName")
    var displayName = ""
}