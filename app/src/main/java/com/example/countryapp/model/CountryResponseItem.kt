package com.example.countryapp.model

data class CountryResponseItem(
    val capital: List<String>,
    val flags: Flags?,
    val name: Name?,
    val region: String?,
)