package com.naufalp2000.indonesia.network

import com.naufalp2000.indonesia.model.batik.Batik
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getProvince(): ProvinsiGet {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(ProvinsiGet::class.java)

            return service

        }
        fun getCovid(): CovidGet {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(CovidGet::class.java)

            return service

        }

        fun getBatik(): BatikGet {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(BatikGet::class.java)

            return service

        }

        fun getMuseum(): MuseumGet {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(MuseumGet::class.java)

            return service

        }
    }

}