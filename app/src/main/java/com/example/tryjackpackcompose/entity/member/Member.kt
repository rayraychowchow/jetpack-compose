package com.example.tryjackpackcompose.entity.member

import com.google.gson.annotations.SerializedName

class Member {
    @SerializedName("email")
    var email: String = ""

    @SerializedName("addedBy")
    var addedBy: String = ""
}