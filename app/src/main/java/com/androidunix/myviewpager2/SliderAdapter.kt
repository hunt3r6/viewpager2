package com.androidunix.myviewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.slide_item_container.view.*

class SliderAdapter(
    private val listImage: ArrayList<SliderItem>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slide_item_container, parent, false)
        return SliderViewHolder(view)
    }

    override fun getItemCount() = listImage.size

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(listImage[position])
    }


    inner class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(sliderItem: SliderItem) {
            with(itemView) {
                imageSlider.setImageResource(sliderItem.image)
            }
        }

    }
}