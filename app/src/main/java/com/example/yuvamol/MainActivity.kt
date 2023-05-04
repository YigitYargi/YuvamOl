
package com.example.yuvamol
import com.example.yuvamol.Database
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yuvamol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    lateinit var db: Database


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // db = Database()

        preferences=getSharedPreferences("kullanicibilgileri", MODE_PRIVATE)


        binding.sifremiunuttum.setOnClickListener {

            intent = Intent(applicationContext,MainSifremiUnuttum::class.java)
            startActivity(intent)
        }

        binding.kayit1.setOnClickListener {

            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }


        binding.giris.setOnClickListener {

            var kullanicieposta = preferences.getString("eposta","")
            var kullaniciparola = preferences.getString("sifre","")

            var giriseposta = binding.epostagiris.text.toString()
            var girissifre = binding.sifregiris.text.toString()

            if((kullanicieposta==giriseposta) && (kullaniciparola==girissifre)) {

                intent = Intent(applicationContext,MainGirisSonrasi::class.java)
                startActivity(intent)

            }
            else {
                Toast.makeText(applicationContext,"Giriş bilgileri hatalı",Toast.LENGTH_LONG).show()



            }
        }

    }
}
