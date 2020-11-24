package com.naufalp2000.indonesia.network

import com.naufalp2000.indonesia.model.province.ProvinceServer
import retrofit2.Call
import retrofit2.http.GET

interface ProvinsiGet {

    @GET("api/daerahindonesia/provinsi")
    fun getDataProvince() : Call<ProvinceServer>
}