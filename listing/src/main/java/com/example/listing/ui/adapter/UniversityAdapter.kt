package com.example.listing.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.database.University
import com.example.listing.R

class UniversityAdapter(
    private var universities: List<University>?,
    private val onItemClick: (University) -> Unit
) : RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = universities?.get(position)
        if (university != null) {
            holder.bind(university)
        }
        holder.itemView.setOnClickListener {
            if (university != null) {
                onItemClick(university)
            }
        }
    }

    override fun getItemCount(): Int {
        return universities?.size ?: 0
    }

    fun updateData(newData: List<University>) {
        universities = newData
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.universityName)
        private val locationTextView: TextView = itemView.findViewById(R.id.universityLocation)

        fun bind(university: University) {
            nameTextView.text = university.name
            locationTextView.text = university.country
        }
    }
}