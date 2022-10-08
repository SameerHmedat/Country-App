package com.example.countryapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countryapp.response.CountryResponse
import com.example.countryapp.service.CountryApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {

    val countriesMutableLiveData=MutableLiveData<Result>()

    init {
        getModelCountry()
    }
    fun getModelCountry(){
        countriesMutableLiveData.value=Result.Loading
        CountryApiService.getInstance().getCountry().enqueue(object : Callback<CountryResponse> {
            override fun onResponse(
                call: Call<CountryResponse>,
                response: Response<CountryResponse>
            ) {
                countriesMutableLiveData.value=Result.Success(response.body()!!)
            }

            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                countriesMutableLiveData.value=Result.Failure(t)
                Log.d("ViewModel",t.message.toString())
            }

        })
    }
}