package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.breads_1.Viewpager.VPAdapter
import com.example.breads_1.Viewpager.ViewPagerItem

class Bun : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerItemArrayList: ArrayList<ViewPagerItem>
    private lateinit var nextButton: Button
    private lateinit var backButton: Button
    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewPager2 = findViewById(R.id.viewpager)
        nextButton = findViewById(R.id.button)
        backButton = findViewById(R.id.back)
        homeButton = findViewById(R.id.home)

        val images = intArrayOf(
            R.drawable.bun,R.drawable.bun1, R.drawable.bun2, R.drawable.bun3, R.drawable.bun4, R.drawable.bun5,R.drawable.bun6,R.drawable.bun7,R.drawable.bun8
        )
        val heading = arrayOf("食材", "Step1", "Step2", "Step3", "Step4","Step5","Step6","Step7","Step8")
        val desc = arrayOf(
            getString(R.string.Bun),
            getString(R.string.Bun_desc1),
            getString(R.string.Bun_desc2),
            getString(R.string.Bun_desc3),
            getString(R.string.Bun_desc4),
            getString(R.string.Bun_desc5),
            getString(R.string.Bun_desc6),
            getString(R.string.Bun_desc7),
            getString(R.string.Bun_desc8),
        )

        viewPagerItemArrayList = ArrayList()

        for (i in images.indices) {
            val viewPagerItem = ViewPagerItem(images[i], heading[i], desc[i])
            viewPagerItemArrayList.add(viewPagerItem)
        }

        val vpAdapter = VPAdapter(viewPagerItemArrayList)

        viewPager2.adapter = vpAdapter

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 2
        viewPager2.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER

        nextButton.setOnClickListener {
            // Move to the next page of ViewPager2
            val nextItem = viewPager2.currentItem + 1
            if (nextItem < viewPagerItemArrayList.size) {
                viewPager2.currentItem = nextItem
            }
        }

        backButton.setOnClickListener {
            // Move to the previous page of ViewPager2
            val previousItem = viewPager2.currentItem - 1
            if (previousItem >= 0) {
                viewPager2.currentItem = previousItem
            }
        }

        homeButton.setOnClickListener {
            // Navigate to the main screen or activity
            val intent = Intent(this, bread::class.java)
            startActivity(intent)
            finish() // Optional: Finish current activity to prevent coming back to it with the back button
        }
    }
}
