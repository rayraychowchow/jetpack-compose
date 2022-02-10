package com.example.tryjackpackcompose.entity

import com.google.gson.annotations.SerializedName

class UserToken {
    @SerializedName("access_token")
    var accessToken: String = ""

    @SerializedName("token_type")
    var tokenType: String = ""

    @SerializedName("refresh_token")
    var refreshToken: String = ""

    @SerializedName("expires_in")
    var expiresIn: Int = 0

    @SerializedName("scope")
    var scope: String = ""
}