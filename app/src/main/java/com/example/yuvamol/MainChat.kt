package com.example.yuvamol
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.yuvamol.databinding.ActivityMainChatBinding
import com.example.yuvamol.databinding.ActivityMainMesajBinding

class MainChat : AppCompatActivity() {
    lateinit var messageInput: EditText
    lateinit var sendButton: Button
   lateinit var chatListView: ListView
     lateinit var chatListAdapter: ArrayAdapter<String>
     val messageList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chat)

        val binding = ActivityMainChatBinding.inflate(layoutInflater)
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
        binding.mesaj.setOnClickListener {
            intent = Intent(applicationContext,MainMesaj::class.java)
            startActivity(intent)
        }



        messageInput = findViewById(R.id.message_input)
        sendButton = findViewById(R.id.send_button)
        chatListView = findViewById(R.id.chat_list_view)

        chatListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messageList)
        chatListView.adapter = chatListAdapter

        sendButton.setOnClickListener {
            val message = messageInput.text.toString()
            messageList.add("You: $message")
            messageInput.text.clear()
            chatListAdapter.notifyDataSetChanged()
        }
    }
}
