package com.example.intent_test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class RRBroadcastReceiver(private val activity: MainActivity) : BroadcastReceiver() {

    constructor() : this(activity = MainActivity())

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null && intent.action == "com.example.receiverapp.ACTION_SEND_UPDATE") {

            // Put the intent value corresponding to your code instead of the gesture
            val gesture = intent.getStringExtra("gesture")
            Log.d("RRreceiver", "Received gesture: $gesture")

            // Create a PendingResult to keep the app alive
            val pendingResult = goAsync()

            // Update the gesture in the UI
            activity.runOnUiThread {
                activity.updateTextView(gesture)

                // Finish the PendingResult to release resources
                pendingResult.finish()
            }
        }
    }
}