package com.naufalp2000.indonesia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.detail.CovidDetail
import com.naufalp2000.indonesia.model.covid.Covid
import com.naufalp2000.indonesia.model.covid.CovidServer
import kotlinx.android.synthetic.main.covid_list.view.*

class AdapterCovid(private val data : ArrayList<Covid>?) : RecyclerView.Adapter<AdapterCovid.CovidViewHolder>() {
    class CovidViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nameProvince = itemView.txt_covid
        val sumCovid = itemView.covid_sum

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.covid_list, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        holder.nameProvince.text = data?.get(position)?.key
        holder.sumCovid.text = data?.get(position)?.jumlah_kasus.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CovidDetail::class.java)
            intent.putExtra("name", data?.get(position)?.key)
            intent.putExtra("date", CovidServer().last_date)
            intent.putExtra("positive", data?.get(position)?.jumlah_kasus.toString())
            intent.putExtra("cure", data?.get(position)?.jumlah_dirawat.toString())
            intent.putExtra("recovered", data?.get(position)?.jumlah_sembuh.toString())
            intent.putExtra("death", data?.get(position)?.jumlah_meninggal.toString())
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}