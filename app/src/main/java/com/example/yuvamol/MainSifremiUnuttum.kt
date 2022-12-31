package com.example.yuvamol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yuvamol.databinding.ActivityMainKayitOlBinding
import com.example.yuvamol.databinding.ActivityMainSifremiUnuttumBinding

class MainSifremiUnuttum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainSifremiUnuttumBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.girisedon.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        //setContentView(R.layout.activity_main_sifremi_unuttum)
    }
}