//package com.example.intent_test
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.os.Handler
//import android.util.Log
//import android.widget.TextView
//
//class MainActivity_2 : AppCompatActivity() {
//    private lateinit var textView: TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        textView = findViewById(R.id.text_view)
//    }
//
//    private val receiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            if (intent?.action == "com.example.senderapp.ACTION_SEND") {
//                val message = intent.getStringExtra("message")
//                textView.text = message
//            }
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        val filter = IntentFilter("com.example.senderapp.ACTION_SEND")
//        registerReceiver(receiver, filter)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        unregisterReceiver(receiver)
//    }
//}