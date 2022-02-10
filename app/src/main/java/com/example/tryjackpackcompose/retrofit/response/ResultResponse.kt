package com.example.tryjackpackcompose.retrofit.response

import com.google.gson.annotations.SerializedName

class ResultResponse {
    @SerializedName("success")
    var success: Boolean = false

    @SerializedName("message")
    var message: String = ""
}