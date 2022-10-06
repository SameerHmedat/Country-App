package com.example.countryapp.service

import com.example.countryapp.response.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CountryApi {

    @GET("v3.1/region/europe")
    fun getCountry():Call<CountryResponse>

}