package com.example.tryjackpackcompose.entity.member

import com.google.gson.annotations.SerializedName

class MemberMap {
    @SerializedName("leader")
    var leader: List<Member> = listOf()

    @SerializedName("consultantSenior")
    var consultantSenior: List<Member> = listOf()

    @SerializedName("consultantJunior")
    var consultantJunior: List<Member> = listOf()

    @SerializedName("contractorSenior")
    var contractorSenior: List<Member> = listOf()

    @SerializedName("worker")
    var worker: List<Member> = listOf()

    @SerializedName("consultant")
    var consultant: List<Member> = listOf()

    @SerializedName("inspector")
    var inspector: List<Member> = listOf()
}