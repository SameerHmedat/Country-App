package com.example.countryapp.model


import com.google.gson.annotations.SerializedName

data class PEN(
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)