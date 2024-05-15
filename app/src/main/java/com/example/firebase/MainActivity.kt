package com.example.firebase

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        lateinit var auth:FirebaseAuth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.signIn.setOnClickListener{
            startActivity(Intent(this ,LoginActivity::class.java))
            finish()
        }
        binding.signOut.setOnClickListener{
            auth.signOut()
            binding.userDetails.text = updatedata()
        }

        }

    override fun onResume() {
        super.onResume()
        binding.userDetails.text = updatedata()
    }
    private fun updatedata():String{
        return "現在登入的帳號 : ${auth.currentUser?.email}"
    }
    }
