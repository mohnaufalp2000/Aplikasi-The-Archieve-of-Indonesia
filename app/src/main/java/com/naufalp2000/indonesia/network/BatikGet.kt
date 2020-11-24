package com.naufalp2000.indonesia.network

import com.naufalp2000.indonesia.model.batik.BatikServer
import retrofit2.Call
import retrofit2.http.GET

interface BatikGet {

    @GET("index.php/batik/all")
    fun getDataBatik() : Call<BatikServer>
}