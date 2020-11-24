package com.naufalp2000.indonesia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.detail.BatikDetail
import com.naufalp2000.indonesia.model.batik.Batik
import kotlinx.android.synthetic.main.batik_list.view.*

class AdapterBatik (private val data : ArrayList<Batik>?) : RecyclerView.Adapter<AdapterBatik.BatikViewHolder>() {
    class BatikViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val batikName = itemView.batik_name
        val batikId = itemView.batik_id
        val batikLowPrice = itemView.batik_low_price
        val batikHighPrice = itemView.batik_high_price
        val batikImage = itemView.batik_img
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.batik_list, parent, false)
        return BatikViewHolder(view)
    }

    override fun onBindViewHolder(holder: BatikViewHolder, position: Int) {
        holder.batikName.text = data?.get(position)?.nama_batik
        holder.batikId.text = data?.get(position)?.id.toString()
        holder.batikLowPrice.text = data?.get(position)?.harga_rendah.toString()
        holder.batikHighPrice.text = data?.get(position)?.harga_tinggi.toString()

        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.link_batik)
            .into(holder.batikImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BatikDetail::class.java)
            intent.putExtra("batikname", data?.get(position)?.nama_batik)
            intent.putExtra("lp", data?.get(position)?.harga_rendah.toString())
            intent.putExtra("hp", data?.get(position)?.harga_tinggi.toString())
            intent.putExtra("batiklocation", data?.get(position)?.daerah_batik)
            intent.putExtra("batikid", data?.get(position)?.id.toString())
            intent.putExtra("makna", data?.get(position)?.makna_batik)
            intent.putExtra("batikimg", data?.get(position)?.link_batik)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}