package com.example.yuvamol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yuvamol.databinding.ActivityMainEvcilHayvanlarimBinding
import com.example.yuvamol.databinding.ActivityMainHayvanEklemeBinding

class MainEvcilHayvanlarim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_evcil_hayvanlarim)
        val binding = ActivityMainEvcilHayvanlarimBinding.inflate(layoutInflater)
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
        binding.hayvanekle.setOnClickListener {
            intent = Intent(applicationContext,MainHayvanEkleme::class.java)
            startActivity(intent)
        }
        binding.incele1.setOnClickListener {
            intent = Intent(applicationContext,MainHayvanBilgileri::class.java)
            startActivity(intent)
        }
        binding.incele2.setOnClickListener {
            intent = Intent(applicationContext,MainHayvanBilgileri::class.java)
            startActivity(intent)
        }
        binding.gecicihayvanlar.setOnClickListener {
            intent = Intent(applicationContext,MainGeciciHayvanlar::class.java)
            startActivity(intent)
        }
        binding.mesaj.setOnClickListener {
            intent = Intent(applicationContext,MainMesaj::class.java)
            startActivity(intent)
        }
    }
}