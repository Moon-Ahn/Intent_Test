package com.example.intent_test

import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private var e = 0

    private lateinit var receiver: RRBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.intent_text)
        textView2 = findViewById(R.id.count_text)

        // Create an instance of the receiver
        receiver = RRBroadcastReceiver(this)

        // Dynamically register the receiver with an IntentFilter
        val filter = IntentFilter("com.twobeone.rader.event.handgesture")
        //registerReceiver(receiver, filter, "com.example.intent_test.permission.MY_PERMISSION", null)
        registerReceiver(receiver, filter)
    }

    fun updateTextView(gesture: String?) {
        if (::textView.isInitialized) {
            textView.text = gesture
        }
        if (::textView.isInitialized) {
            textView2.text = e.toString()
            e += 1
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Unregister the broadcast receiver
        unregisterReceiver(receiver)
    }
}