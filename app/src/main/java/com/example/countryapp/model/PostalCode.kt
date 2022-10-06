package com.example.countryapp.model


import com.google.gson.annotations.SerializedName

data class PostalCode(
    @SerializedName("format")
    val format: String,
    @SerializedName("regex")
    val regex: String
)