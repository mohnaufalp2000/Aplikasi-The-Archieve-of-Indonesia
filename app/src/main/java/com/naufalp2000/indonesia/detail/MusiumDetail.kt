package com.naufalp2000.indonesia.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufalp2000.indonesia.R
import kotlinx.android.synthetic.main.activity_batik_detail.*
import kotlinx.android.synthetic.main.activity_musium_detail.*

class MusiumDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_musium_detail)

        val name = intent.getStringExtra("musiumname")
        val id = intent.getStringExtra("musiumid")
        val alamat = intent.getStringExtra("musiumalamat")
        val kecamatan = intent.getStringExtra("musiumkecamatan")
        val kota = intent.getStringExtra("musiumkota")
        val provinsi = intent.getStringExtra("musiumprovinsi")

        // Show Data
        detail_museum_name.text = name
        detail_museum_id.text = id
        detail_musium_address.text = alamat
        detail_musium_kecamatan.text = kecamatan
        detail_musium_city.text = kota
        detail_museum_province.text = provinsi

    }
}