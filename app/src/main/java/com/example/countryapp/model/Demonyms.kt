package com.example.countryapp.model


import com.google.gson.annotations.SerializedName

data class Demonyms(
    @SerializedName("eng")
    val eng: Eng,
    @SerializedName("fra")
    val fra: Fra
)