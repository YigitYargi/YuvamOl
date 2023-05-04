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

        binding.filtreleme1.setOnClickListener {
            intent = Intent(applicationContext,MainBakiciFiltreleme::class.java)
            startActivity(intent)
        }

        binding.profil.setOnClickListener {
            intent = Intent(applicationContext,MainProfilDuzenleme::class.java)
            startActivity(intent)
        }
        binding.bakici.setOnClickListener {
            intent = Intent(applicationContext,Mainbakicilistesi::class.java)
            startActivity(intent)
        }

        binding.ayarlar.setOnClickListener {
            intent = Intent(applicationContext,MainAyarlar::class.java)
            startActivity(intent)
        }
        binding.evcilhayvanlar.setOnClickListener {
            intent = Intent(applicationContext,MainEvcilHayvanlarim::class.java)
            startActivity(intent)
        }
        binding.anasayfa.setOnClickListener {
            intent = Intent(applicationContext,MainGirisSonrasi::class.java)
            startActivity(intent)
        }
        binding.mesaj.setOnClickListener {
            intent = Intent(applicationContext,MainMesaj::class.java)
            startActivity(intent)
        }

    }
}