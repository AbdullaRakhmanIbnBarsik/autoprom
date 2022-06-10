package com.bignerdranch.android.autoprom.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.autoprom.R
import com.bignerdranch.android.autoprom.ui.Models.AdsModel

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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)

        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.largeTextView.text = ads[position].name
        holder.costTextView.text = ads[position].cost
        holder.colorTextView.text = ads[position].color
        holder.yearTextView.text = ads[position].year.toString()
        holder.cityTextView.text = ads[position].city
        holder.dateTextView.text = ads[position].date
    }

    override fun getItemCount(): Int {
        return ads.size;
    }
}