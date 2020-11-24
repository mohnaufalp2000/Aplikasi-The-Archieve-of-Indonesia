package com.naufalp2000.indonesia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.detail.MusiumDetail
import com.naufalp2000.indonesia.model.museum.Museum
import kotlinx.android.synthetic.main.musium_list.view.*

class AdapterMuseum (private val data : ArrayList<Museum>?) : RecyclerView.Adapter<AdapterMuseum.MuseumViewHolder>() {
    class MuseumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val nameMuseum = itemView.museum_name
        val locationMuseum = itemView.museum_location

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.musium_list, parent, false)
        return MuseumViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuseumViewHolder, position: Int) {
        holder.nameMuseum.text = data?.get(position)?.nama
        holder.locationMuseum.text = data?.get(position)?.alamat_jalan

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MusiumDetail::class.java)
            intent.putExtra("musiumname", data?.get(position)?.nama)
            intent.putExtra("musiumid", data?.get(position)?.museum_id)
            intent.putExtra("musiumalamat", data?.get(position)?.alamat_jalan)
            intent.putExtra("musiumkecamatan", data?.get(position)?.kecamatan)
            intent.putExtra("musiumkota", data?.get(position)?.kabupaten_kota)
            intent.putExtra("musiumprovinsi", data?.get(position)?.propinsi)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}