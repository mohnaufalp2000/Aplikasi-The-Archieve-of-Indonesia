package com.naufalp2000.indonesia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufalp2000.indonesia.R
import com.naufalp2000.indonesia.menu.BatikActivity
import com.naufalp2000.indonesia.menu.MusiumActivity
import com.naufalp2000.indonesia.menu.ProvinceActivity
import com.naufalp2000.indonesia.model.Title
import kotlinx.android.synthetic.main.info_list.view.*

class AdapterTitle(private val data : ArrayList<Title>) : RecyclerView.Adapter<AdapterTitle.TitleViewHolder>() {
    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title_info
        val image = itemView.img_info
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.info_list, parent, false)
        return TitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.title.text = data[position].title

        Glide.with(holder.itemView.context)
            .load(data[position].img)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            when(position){
                 0 -> {
                     val proviceIntent = Intent(holder.itemView.context, ProvinceActivity::class.java)
                     holder.itemView.context.startActivity(proviceIntent)
                 }

                1 -> {
                    val batikIntent = Intent(holder.itemView.context, BatikActivity::class.java)
                    holder.itemView.context.startActivity(batikIntent)
                }

                2 -> {
                    val musiumIntent = Intent(holder.itemView.context, MusiumActivity::class.java)
                    holder.itemView.context.startActivity(musiumIntent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}