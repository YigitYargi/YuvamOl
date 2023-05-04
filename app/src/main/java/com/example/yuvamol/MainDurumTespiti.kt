package com.example.yuvamol

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yuvamol.databinding.ActivityMainDurumTespitiBinding
import com.example.yuvamol.databinding.ActivityMainGeciciHayvanlarBinding

class MainDurumTespiti : AppCompatActivity() {


    private val imagePicker = registerForActivityResult(ActivityResultContracts.GetMultipleContents()) { uris: List<Uri>? ->
        if (uris != null) {
            val adapter = recyclerView.adapter as PhotoAdapter
            adapter.addPhotos(uris)
        }
    }
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_durum_tespiti)
        val binding = ActivityMainDurumTespitiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val switch1: Switch = findViewById(R.id.switch1)
        switch1.setThumbTintList(ContextCompat.getColorStateList(this, R.color.switchcolor))


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PhotoAdapter()

        val buttonAddPhotos = findViewById<Button>(R.id.button11)
        buttonAddPhotos.setOnClickListener {
            imagePicker.launch("image/*")
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
        val buttonGallery = findViewById<Button>(R.id.button11)
        buttonGallery.setOnClickListener { view ->
            imagePicker.launch("image/*")
        }
    }

    inner class PhotoAdapter : RecyclerView.Adapter<PhotoViewHolder>() {
        private val photos = mutableListOf<Uri>()

        fun addPhotos(uris: List<Uri>) {
            photos.addAll(uris)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
            return PhotoViewHolder(view)
        }

        override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            val photoUri = photos[position]
            holder.bind(photoUri)
        }

        override fun getItemCount(): Int {
            return photos.size
        }
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(uri: Uri) {
            imageView.setImageURI(uri)
        }
    }

}