package com.naufalp2000.indonesia.network

import com.naufalp2000.indonesia.model.covid.CovidServer
import retrofit2.Call
import retrofit2.http.GET

interface CovidGet {
    @GET("api/prov.json")
    fun getDataCovid() : Call<CovidServer>
}