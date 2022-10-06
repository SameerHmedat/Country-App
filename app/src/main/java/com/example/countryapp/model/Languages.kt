package com.example.countryapp.model


import com.google.gson.annotations.SerializedName

data class Languages(
    @SerializedName("aym")
    val aym: String,
    @SerializedName("que")
    val que: String,
    @SerializedName("spa")
    val spa: String
)