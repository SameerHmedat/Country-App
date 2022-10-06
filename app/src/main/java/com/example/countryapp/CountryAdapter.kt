package com.example.countryapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countryapp.model.CountryResponseItem
import kotlinx.android.synthetic.main.country_item_row.view.*

class CountryAdapter(private var countries: ArrayList<CountryResponseItem>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.country_item_row, parent, false
        )
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindCountry(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setCountryList(countries: ArrayList<CountryResponseItem>?) {
        this.countries = countries!!
        notifyDataSetChanged()
    }


    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //one country only
        fun bindCountry(countryResponseItem: CountryResponseItem) {
            if (countryResponseItem.name.common == "Israel") {

            }
            else {
                itemView.txtCapital.text = "Capital: ${countryResponseItem.capital[0]}"
                itemView.txtCountry.text = countryResponseItem.name.common
                itemView.txtRegion.text = "Region: ${countryResponseItem.region}"
                Glide.with(itemView).load(countryResponseItem.flags.png).into(itemView.imgCountry)
            }
        }

    }
}