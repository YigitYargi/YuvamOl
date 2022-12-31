package com.example.yuvamol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yuvamol.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.kayitol.setOnClickListener {

            var kullaniciesposta = binding.epostakayit.text.toString()
            var kullanicisifre = binding.sifrekayit.text.toString()
            var kullanicitelno = binding.telnokayit.text.toString()
            var kullaniciisim = binding.isimkayit.text.toString()
            var kullanicisoyisim = binding.soyisimkayit.text.toString()
var SharedPreferences = this.getSharedPreferences("kullanicibilgileri", MODE_PRIVATE)
var editor = SharedPreferences.edit()

        editor.putString("eposta","$kullaniciesposta").apply()
            editor.putString("sifre","$kullanicisifre").apply()
            editor.putString("telno","$kullanicitelno").apply()
            editor.putString("isim","$kullaniciisim").apply()
            editor.putString("soyisim","$kullanicisoyisim").apply()
        Toast.makeText(applicationContext,"Kayit basarili",Toast.LENGTH_LONG).show()
binding.epostakayit.text.clear()
            binding.sifrekayit.text.clear()
            binding.telnokayit.text.clear()
            binding.isimkayit.text.clear()
            binding.soyisimkayit.text.clear()
        }
        binding.girisedon.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
    }
}
}