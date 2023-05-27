package com.federicocotogno.retro2newslist.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newstoday.R
import com.example.newstoday.api.News

class RecyclerAdapter(
    private var data: ArrayList<News>,
    private var c : Context
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.iv_title)
        val itemDescription: TextView = itemView.findViewById(R.id.iv_description)
        val itemPicture: ImageView = itemView.findViewById(R.id.iv_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = data[position].title
        holder.itemDescription.text = data[position].description

        Glide.with(holder.itemPicture)
            .load(data[position].image)
            .into(holder.itemPicture)

        holder.itemView.setOnClickListener {

            val uriString = data[position].url
            val uri = Uri.parse(uriString)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            it.context.startActivity(intent)
            Toast.makeText(c,"Response..$uri",Toast.LENGTH_SHORT).show()

        }
    }
}