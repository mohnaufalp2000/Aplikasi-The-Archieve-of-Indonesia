package com.naufalp2000.indonesia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.model.province.Province
import kotlinx.android.synthetic.main.province_list.view.*

class AdapterProvince (private val data : ArrayList<Province>?) : RecyclerView.Adapter<AdapterProvince.ProvinceViewHolder>() {

    class ProvinceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nameProvince = itemView.txt_province
        val idProvince = itemView.id_province
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.province_list, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.nameProvince.text = data?.get(position)?.nama
        holder.idProvince.text = data?.get(position)?.id.toString()

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}