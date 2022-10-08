package com.example.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryapp.model.CountryResponseItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }
    private var countryList: ArrayList<CountryResponseItem> = arrayListOf()
    private var countryAdapter = CountryAdapter(countryList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.countriesMutableLiveData.observe(this@MainActivity) { result ->
            when (result) {
                is Result.Failure -> {
                    txtError.visibility = View.VISIBLE
                    progressError.visibility = View.GONE
                    rcCountry.visibility = View.GONE
                    Log.d("Failure","Failure")

                }

                Result.Loading -> {
                    progressError.visibility = View.VISIBLE
                    txtError.visibility = View.GONE
                    rcCountry.visibility = View.GONE
                }
                is Result.Success -> {
                    progressError.visibility = View.GONE
                    txtError.visibility = View.GONE
                    rcCountry.visibility = View.VISIBLE
                    countryAdapter.setCountryList(result.countries)
                    Log.d("Numbers of countries ",countryAdapter.countries.size.toString())

                }
            }


        }


        //     countryAdapter.setCountryList(countries)
//            countryAdapter.notifyDataSetChanged()
        rcCountry.layoutManager = LinearLayoutManager(this)
        rcCountry.setHasFixedSize(true)

        rcCountry.adapter = countryAdapter

    }
}

sealed class Result {
    data class Success(val countries: ArrayList<CountryResponseItem>) : Result()
    data class Failure(val exception: Throwable) : Result()
    object Loading : Result()
}

/*
private fun setupInfoUIList() {
    rvElement.layoutManager = LinearLayoutManager(this)
    rvElement.setHasFixedSize(true)

    rvCard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    rvCard.setHasFixedSize(true)

    viewModel.dataMutableLiveData.observe(this@MainActivity) { result ->
        when (result) {
            is Result.Failure -> {
                empty_view.error()
                    .setOnClickListener { v -> showLoading() }
                    .show()
//                    txtError.visibility = View.VISIBLE
//                    progressError.visibility = View.GONE
//                    mainLayout.visibility = View.GONE
            }
            Result.Loading -> {
                empty_view.loading().show()
//                    progressError.visibility = View.VISIBLE
//                    txtError.visibility = View.GONE
//                    mainLayout.visibility = View.GONE
            }
            is Result.Success -> {
                empty_view.content().show()
//                    progressError.visibility = View.GONE
//                    txtError.visibility = View.GONE
//                    mainLayout.visibility = View.VISIBLE
                setDataOnViews(result.data) //the thing exchange between viewModel and Activity
            }
        }

        myAdapter.setOnItemClickListener(object : ElementAdapter.OnItemClickedListener {
            override fun onItemClick(position: Int) {
                edt_city_name.setText(myAdapter.newList[position].city_name)
                val cityName = edt_city_name.text.toString()
                rvElement.visibility = View.INVISIBLE
                viewModel.getData(cityName)
            }
        }
        )
    }
}
*/