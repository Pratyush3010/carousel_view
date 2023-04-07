package com.example.carouselview

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    val SampleImage = intArrayOf(
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewpager = findViewById<ViewPager2>(R.id.viewpager)

        val carouselview = findViewById<CarouselView>(R.id.carouselview)


        carouselview.pageCount = SampleImage.size
        carouselview.setImageListener(imageListener)



                viewpager.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


            val demoData = arrayListOf(
                "“I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.”",
                "\n" +
                        "“You've gotta dance like there's nobody watching,\n" +
                        "Love like you'll never be hurt,\n" +
                        "Sing like there's nobody listening,\n" +
                        "And live like it's heaven on earth.”",
                "“If you want to know what a man's like, take a good look at how he treats his inferiors, not his equals.”",
                "“I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.”",
                "“Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that.”"
            )

            viewpager.adapter = CarouselAdapter(demoData)


            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
            compositePageTransformer.addTransformer { page, position ->
                val r = 1- abs(position)
                page.scaleY = (0.8f + r * 0.30f)
            }

            viewpager.setPageTransformer(compositePageTransformer)
        }
    }

    val imageListener : ImageListener = object : ImageListener{
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            imageView?.setImageResource(SampleImage[position])
        }
    }

}