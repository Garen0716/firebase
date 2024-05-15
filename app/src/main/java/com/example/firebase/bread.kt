package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class bread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bread)

        // 获取 ImageButton 和 Button 并设置点击事件
        val imageButton1 = findViewById<ImageButton>(R.id.Imagebutton1)
        val imageButton2 = findViewById<ImageButton>(R.id.ImageButton2)

        val imageButton3 = findViewById<ImageButton>(R.id.ImageButton3)
        val imageButton4 = findViewById<ImageButton>(R.id.ImageButton4)
        val button1 = findViewById<Button>(R.id.Button1)
        val button2 = findViewById<Button>(R.id.Button2)

        val button3 = findViewById<Button>(R.id.Button3)
        val button4 = findViewById<Button>(R.id.Button4)
        val button66 = findViewById<Button>(R.id.Button66)
        imageButton1.setOnClickListener {
            val intent = Intent(this, Ciabatta::class.java)
            startActivity(intent)
        }

        // 点击 Button 时跳转
        button1.setOnClickListener {
            val intent = Intent(this, Ciabatta::class.java)
            startActivity(intent)
        }
        imageButton2.setOnClickListener {
            val intent = Intent(this, Crossiant::class.java)
            startActivity(intent)
        }

        // 点击 Button 时跳转
        button2.setOnClickListener {
            val intent = Intent(this, Crossiant::class.java)
            startActivity(intent)
        }

        imageButton3.setOnClickListener {
            val intent = Intent(this, Lemontart::class.java)
            startActivity(intent)
        }

        // 点击 Button 时跳转
        button3.setOnClickListener {
            val intent = Intent(this, Lemontart::class.java)
            startActivity(intent)
        }
        imageButton4.setOnClickListener {
            val intent = Intent(this, Bun::class.java)
            startActivity(intent)
        }

        // 点击 Button 时跳转
        button4.setOnClickListener {
            val intent = Intent(this, Bun::class.java)
            startActivity(intent)
        }
        button66.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 处理窗口插入
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}
