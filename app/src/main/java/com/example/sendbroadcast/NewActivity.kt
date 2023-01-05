package com.example.sendbroadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewActivity : AppCompatActivity() {
    private lateinit var btSendBroadcast: Button
    private var BROADCAST_ACTION = "com.example.sendbroadcast.SEND_TOAST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        btSendBroadcast = findViewById(R.id.btn2)
        btSendBroadcast.setOnClickListener {
            sendToast()
        }
    }

    private fun sendToast() {
        val intent = Intent()
        intent.action =BROADCAST_ACTION
        sendBroadcast(intent)
    }
}