package com.naufalp2000.indonesia.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.naufalp2000.indonesia.R
import kotlinx.android.synthetic.main.activity_batik_detail.*
import kotlinx.android.synthetic.main.activity_covid_detail.*

class BatikDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik_detail)

        val name = intent.getStringExtra("batikname")
        val lp = intent.getStringExtra("lp")
        val hp = intent.getStringExtra("hp")
        val location = intent.getStringExtra("batiklocation")
        val id = intent.getStringExtra("batikid")
        val makna = intent.getStringExtra("makna")
        val image = intent.getStringExtra("batikimg")

        // Show Data
        detail_batik_name.text = name
        detail_low_price.text = lp
        detail_high_price.text = hp
        detail_batik_location.text = location
        detail_batik_id.text = id
        detail_makna.text = makna

        Glide.with(this)
            .load(image)
            .into(detail_img_batik)


    }
}