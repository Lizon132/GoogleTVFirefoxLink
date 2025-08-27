package com.example.firefoxtvshortcut.ui

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent()
        intent.component = ComponentName(
            "org.mozilla.firefox",     // Package name
            "org.mozilla.firefox.App"  // Main launcher activity
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        finish()
    }
}
