package com.naufalp2000.indonesia.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.adapter.AdapterBatik
import com.naufalp2000.indonesia.model.batik.Batik
import com.naufalp2000.indonesia.model.batik.BatikServer
import com.naufalp2000.indonesia.model.covid.CovidServer
import com.naufalp2000.indonesia.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_batik.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BatikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik)

        ConfigNetwork.getBatik().getDataBatik().enqueue(object : Callback<BatikServer> {
            override fun onResponse(call: Call<BatikServer>, response: Response<BatikServer>) {
                if (response.isSuccessful){
                    progress_batik.visibility = View.GONE
                    var data = response.body()?.hasil
                    showListBatik(data)
                }
            }

            override fun onFailure(call: Call<BatikServer>, t: Throwable) {
                Toast.makeText(this@BatikActivity, "Gak Bisa Connect Gan", Toast.LENGTH_LONG).show()

            }

        })

        back_batik.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showListBatik(data: ArrayList<Batik>?) {
        rv_batik.layoutManager = GridLayoutManager(this, 2)
        rv_batik.adapter = AdapterBatik(data)
    }
}