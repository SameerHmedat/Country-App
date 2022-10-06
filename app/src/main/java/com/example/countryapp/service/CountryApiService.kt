package com.example.countryapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

    object CountryApiService{

        private const val BASE_URL="https://restcountries.com/"
        private var countryApi:CountryApi?=null

        fun getInstance():CountryApi{
                if(countryApi==null){
                    val retrofit=Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    countryApi=retrofit.create(CountryApi::class.java)
                }
            return countryApi!!
        }

    }
