package com.naufalp2000.indonesia.network

import com.naufalp2000.indonesia.model.museum.MuseumServer
import retrofit2.Call
import retrofit2.http.GET

interface MuseumGet {

    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getDataMuseum() : Call<MuseumServer>
}