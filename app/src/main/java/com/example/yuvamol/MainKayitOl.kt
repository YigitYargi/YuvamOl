package com.example.yuvamol

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.yuvamol.databinding.ActivityMainKayitOlBinding

import com.google.gson.Gson
import java.net.URL
import java.io.File

class MainKayitOl : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kayitol.setOnClickListener {
            val kullaniciesposta = binding.epostakayit.text.toString()
            val kullanicisifre = binding.sifrekayit.text.toString()
            val kullanicitelno = binding.telnokayit.text.toString()
            val kullaniciisim = binding.isimkayit.text.toString()
            val kullanicisoyisim = binding.soyisimkayit.text.toString()

            val editor = this.getSharedPreferences("kullanicibilgileri", MODE_PRIVATE).edit()
            editor.putString("eposta", kullaniciesposta)
            editor.putString("sifre", kullanicisifre)
            editor.putString("telno", kullanicitelno)
            editor.putString("isim", kullaniciisim)
            editor.putString("soyisim", kullanicisoyisim)
            editor.apply()

            Toast.makeText(applicationContext, "Kayit basarili", Toast.LENGTH_LONG).show()
            binding.epostakayit.text.clear()
            binding.sifrekayit.text.clear()
            binding.telnokayit.text.clear()
            binding.isimkayit.text.clear()
            binding.soyisimkayit.text.clear()

            val url = "https://a3f53d7a-f3a4-4b3e-8f61-bab2ce940bd6.mock.pstmn.io/kullanici"
            FetchDataTask().execute(url)
        }

        binding.girisedon.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private inner class FetchDataTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String {
            val url = params[0]
            return URL(url).readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val jsonString = result ?: ""
            val file = File(applicationContext.filesDir, "user.txt")
            file.writeText(jsonString)
            println(jsonString)
        }
    }
}