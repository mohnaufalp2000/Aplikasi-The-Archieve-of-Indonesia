package com.naufalp2000.indonesia.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.adapter.AdapterProvince
import com.naufalp2000.indonesia.model.province.Province
import com.naufalp2000.indonesia.model.province.ProvinceServer
import com.naufalp2000.indonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batik.*
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)

        ConfigNetwork.getProvince().getDataProvince().enqueue(object : Callback<ProvinceServer>{
            override fun onResponse(
                call: Call<ProvinceServer>,
                response: Response<ProvinceServer>
            ) {
                if (response.isSuccessful){
                    val data = response.body()?.provinsi
                    showListProvince(data)
                }
            }

            override fun onFailure(call: Call<ProvinceServer>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "Gak Bisa Connect Gan", Toast.LENGTH_LONG).show()
            }

        })

        back_province.setOnClickListener {
            onBackPressed()
        }
    }


    private fun showListProvince(data : ArrayList<Province>?) {
        rv_province.layoutManager = LinearLayoutManager(this)
        rv_province.adapter = AdapterProvince(data)
    }

}