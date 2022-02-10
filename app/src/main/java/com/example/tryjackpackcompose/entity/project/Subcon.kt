package com.example.tryjackpackcompose.entity.project

import com.example.tryjackpackcompose.entity.member.Member
import com.google.gson.annotations.SerializedName

class Subcon {
    @SerializedName("id")
    var id: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("companyName")
    var companyName: String = ""

    @SerializedName("trade")
    var trade: List<String> = listOf()

    @SerializedName("member")
    var member: List<Member> = listOf()
}