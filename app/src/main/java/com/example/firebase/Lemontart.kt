package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.breads_1.Viewpager.VPAdapter
import com.example.breads_1.Viewpager.ViewPagerItem

class Lemontart : AppCompatActivity() {

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
            R.drawable.lemon13, R.drawable.lemon1, R.drawable.lemon2, R.drawable.lemon3, R.drawable.lemon4, R.drawable.lemon5,R.drawable.lemon6,R.drawable.lemon7,R.drawable.lemon8,R.drawable.lemon9,R.drawable.lemon10,R.drawable.lemon11,R.drawable.lemon12,R.drawable.lemon13
        )
        val heading = arrayOf("食材", "Step1", "Step2", "Step3", "Step4","Step5","Step6","Step7","Step8","Step9","Step10","Step11","Step12","Step13")
        val desc = arrayOf(
            getString(R.string.Lemon),
            getString(R.string.Lem_desc1),
            getString(R.string.Lem_desc2),
            getString(R.string.Lem_desc3),
            getString(R.string.Lem_desc4),
            getString(R.string.Lem_desc5),
            getString(R.string.Lem_desc6),
            getString(R.string.Lem_desc7),
            getString(R.string.Lem_desc8),
            getString(R.string.Lem_desc9),
            getString(R.string.Lem_desc10),
            getString(R.string.Lem_desc11),
            getString(R.string.Lem_desc12),
            getString(R.string.Lem_desc13),
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
