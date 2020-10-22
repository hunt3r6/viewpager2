package com.androidunix.myviewpager2

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private var listImage = ArrayList<SliderItem>()
    private lateinit var dataPhoto: TypedArray


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataPhoto = resources.obtainTypedArray(R.array.data_slide)
        for (position in 0..3) {
            val image = SliderItem(dataPhoto.getResourceId(position, -1))
            listImage.add(image)
        }

        val sliderAdapter = SliderAdapter(listImage, viewPagerImage)

        viewPagerImage.adapter = sliderAdapter
        viewPagerImage.clipToPadding = false
        viewPagerImage.clipChildren = false
        viewPagerImage.offscreenPageLimit = 3
        viewPagerImage.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r: Float = 1 - abs(position)
            page.scaleY = 0.5f + r * 0.5f
        }

        viewPagerImage.setPageTransformer(compositePageTransformer)


    }
}