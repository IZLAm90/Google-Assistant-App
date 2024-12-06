package com.izlam.voice


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        handleIntent(intent)
    }
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val action = intent.action
        when (action) {
            "android.intent.action.VIEW" -> {
                val exerciseType = intent.getStringExtra("exerciseType")
                val stopExercise = intent.getStringExtra("stopExercise")

                exerciseType?.let {
                    Log.d("MainActivity", "Start exercise: $it")
                    // Handle starting exercise
                }

                stopExercise?.let {
                    Log.d("MainActivity", "Stop exercise: $it")
                    // Handle stopping exercise
                }
            }
            else -> Log.d("MainActivity", "Unhandled action: $action")
        }
    }
}
