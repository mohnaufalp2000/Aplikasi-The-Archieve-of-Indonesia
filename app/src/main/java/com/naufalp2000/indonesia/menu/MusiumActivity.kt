package com.naufalp2000.indonesia.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.adapter.AdapterMuseum
import com.naufalp2000.indonesia.model.museum.Museum
import com.naufalp2000.indonesia.model.museum.MuseumServer
import com.naufalp2000.indonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batik.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_musium.*
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusiumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musium)

        ConfigNetwork.getMuseum().getDataMuseum().enqueue(object : Callback<MuseumServer>{
            override fun onResponse(call: Call<MuseumServer>, response: Response<MuseumServer>) {
                if (response.isSuccessful){
                    progress_museum.visibility = View.GONE
                    var data = response?.body()?.data
                    showListMuseum(data)
                }
            }

            override fun onFailure(call: Call<MuseumServer>, t: Throwable) {
                Toast.makeText(this@MusiumActivity, "Gak Bisa Connect Gan", Toast.LENGTH_LONG).show()
            }
        })

        back_musium.setOnClickListener {
            onBackPressed()
        }

    }

    private fun showListMuseum(data: ArrayList<Museum>?) {
        rv_museum.layoutManager = LinearLayoutManager(this)
        rv_museum.adapter = AdapterMuseum(data)
    }
}