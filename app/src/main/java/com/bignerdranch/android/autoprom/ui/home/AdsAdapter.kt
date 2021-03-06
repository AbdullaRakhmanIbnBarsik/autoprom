package com.bignerdranch.android.autoprom.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.autoprom.R
import com.bignerdranch.android.autoprom.ui.Models.AdsModel
import com.bumptech.glide.Glide

class AdsAdapter(private val ads: MutableList<AdsModel>) :
    RecyclerView.Adapter<AdsAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTextView: TextView
        val costTextView: TextView
        val colorTextView: TextView;
        val yearTextView: TextView;
        val cityTextView: TextView;
        val dateTextView: TextView;
        val imageView: ImageView;

        init {
            largeTextView = itemView.findViewById(R.id.name_ads);
            costTextView = itemView.findViewById(R.id.cost_ads);
            colorTextView = itemView.findViewById(R.id.color_ads);
            yearTextView = itemView.findViewById(R.id.year_ads);
            cityTextView = itemView.findViewById(R.id.city_ads);
            dateTextView = itemView.findViewById(R.id.date_ads);
            imageView = itemView.findViewById(R.id.image_ads);
        }

        fun bind(property: AdsModel) {
            largeTextView.text = property.name
            costTextView.text = property.cost
            colorTextView.text = property.color
            yearTextView.text = property.year.toString()
            cityTextView.text = property.city
            dateTextView.text = property.date

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, property.name, Toast.LENGTH_SHORT).show();
            }

            Glide.with(itemView.context).load(property.image).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)

        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ads[position]);
    }

    override fun getItemCount(): Int {
        return ads.size;
    }
}