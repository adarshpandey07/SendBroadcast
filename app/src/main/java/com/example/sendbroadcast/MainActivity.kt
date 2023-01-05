package com.example.sendbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private var BROADCAST_ACTION = "com.example.sendbroadcast.SEND_TOAST"
    lateinit var user :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.btn1)
        user = "Adarsh"

        registerBroadcast(applicationContext)

        btn1.setOnClickListener {
            val intent = Intent(this@MainActivity,NewActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun registerBroadcast(context: Context?) {
        val filter = IntentFilter(BROADCAST_ACTION)
        context?.registerReceiver(BroadcastApp(),filter)
        Log.d(user,"A")

    }
    inner class BroadcastApp : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
          Toast.makeText(applicationContext,"broadcast recieved",Toast.LENGTH_SHORT).show()
        }

    }

    }


