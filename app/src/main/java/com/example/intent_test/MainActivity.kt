package com.example.intent_test
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.intent_test.RRBroadcastReceiver

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private var e = 0
    private val receiver = RRBroadcastReceiver(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.intent_text)
        textView2 = findViewById(R.id.count_text)

        // Register the receiver to receive the intent data
        val filter = IntentFilter("com.example.receiverapp.ACTION_SEND_UPDATE")
        registerReceiver(receiver, filter,"com.example.intent_test.permission.MY_PERMISSION",null)
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