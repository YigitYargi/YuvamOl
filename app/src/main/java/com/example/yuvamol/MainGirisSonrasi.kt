package com.example.yuvamol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yuvamol.databinding.ActivityMainGirisSonrasiBinding
import com.example.yuvamol.databinding.ActivityMainKayitOlBinding

class MainGirisSonrasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_giris_sonrasi)
        val binding = ActivityMainGirisSonrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.girisedon.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}