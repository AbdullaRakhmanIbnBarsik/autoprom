package com.bignerdranch.android.autoprom.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.autoprom.R

class AdsAdapter(private val names: List<String>) :
    RecyclerView.Adapter<AdsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val largeTextView: TextView = itemView.findViewById(R.id.name_ads);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.largeTextView.text = "Окипадари кот"
    }

    override fun getItemCount(): Int {
        return names.size;
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView
//        var itemKategori: TextView
//        var itemIsi: TextView

        init {
            itemKode = itemView.findViewById(R.id.name_ads)
//            itemKategori = itemView.findViewById(R.id.kategori)
//            itemIsi = itemView.findViewById(R.id.isiPertanyaan)

//            itemView.setOnClickListener {
//                var position: Int = getAdapterPosition()
//                val context = itemView.context
//                val intent = Intent(context, null).apply {
//                    putExtra("NUMBER", position)
//                    putExtra("CODE", itemKode.text)
////                    putExtra("CATEGORY", itemKategori.text)
////                    putExtra("CONTENT", itemIsi.text)
//                }
//                context.startActivity(intent)
//            }
        }
    }
}