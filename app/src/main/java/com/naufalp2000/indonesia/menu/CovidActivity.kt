package com.naufalp2000.indonesia.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.adapter.AdapterCovid
import com.naufalp2000.indonesia.model.covid.Covid
import com.naufalp2000.indonesia.model.covid.CovidServer
import com.naufalp2000.indonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batik.*
import kotlinx.android.synthetic.main.activity_covid.*
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        ConfigNetwork.getCovid().getDataCovid().enqueue(object : Callback<CovidServer>{
            override fun onResponse(call: Call<CovidServer>, response: Response<CovidServer>) {
                if (response.isSuccessful){
                    var data = response.body()?.list_data
                    showListCovid(data)
                }
            }

            override fun onFailure(call: Call<CovidServer>, t: Throwable) {
                Toast.makeText(this@CovidActivity, "Gak Bisa Connect Gan", Toast.LENGTH_LONG).show()

            }

        })

        back_covid.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showListCovid(data: ArrayList<Covid>?) {
        rv_covid.layoutManager = LinearLayoutManager(this)
        rv_covid.adapter = AdapterCovid(data)
    }
}