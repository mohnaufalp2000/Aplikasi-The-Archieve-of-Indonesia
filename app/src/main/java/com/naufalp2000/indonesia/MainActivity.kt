package com.naufalp2000.indonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufalp2000.indonesia.adapter.AdapterTitle
import com.naufalp2000.indonesia.menu.CovidActivity
import com.naufalp2000.indonesia.model.Title
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_covid.setOnClickListener {
            showCovidActivity()
        }
        showListInfo()
    }

    private fun showCovidActivity() {
        val intent = Intent(this@MainActivity, CovidActivity::class.java)
        startActivity(intent)
    }


    private fun showListInfo() {
        val listData = ArrayList<Title>()
        listData.add(Title("Provinsi di Indonesia", R.drawable.indonesia_islands))
        listData.add(Title("Batik Kita", R.drawable.batik))
        listData.add(Title("Musium di Indonesia", R.drawable.musium))


        rv_info.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_info.adapter = AdapterTitle(listData)
    }

}