package com.example.yuvamol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yuvamol.databinding.ActivityMainDurumTespitiBinding
import com.example.yuvamol.databinding.ActivityMainGeciciHayvanlarBinding

class MainDurumTespiti : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_durum_tespiti)
        val binding = ActivityMainDurumTespitiBinding.inflate(layoutInflater)
        setContentView(binding.root)
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


    }
}