package com.naufalp2000.indonesia.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufalp2000.indonesia.R
import kotlinx.android.synthetic.main.activity_covid_detail.*

class CovidDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_detail)

        val name = intent.getStringExtra("name")
        val date = intent.getStringExtra("date")
        val positive = intent.getStringExtra("positive")
        val cure = intent.getStringExtra("cure")
        val recovered = intent.getStringExtra("recovered")
        val death = intent.getStringExtra("death")

        // Show Data
        detail_covid_province.text = name
        detail_updated_covid.text = date
        detail_positive_covid.text = positive
        detail_cure_covid.text = cure
        detail_recovered_covid.text = recovered
        detail_death_covid.text = death

    }
}