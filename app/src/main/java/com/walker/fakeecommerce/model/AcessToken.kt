package com.walker.fakeecommerce.model

import com.google.gson.annotations.SerializedName

data class AcessToken(
    @SerializedName("acess_token")
    val acessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String
)
