package com.example.countryapp.model


import com.google.gson.annotations.SerializedName

data class Cym(
    @SerializedName("common")
    val common: String,
    @SerializedName("official")
    val official: String
)