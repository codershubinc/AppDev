package com.example.app_projaect_0

import android.os.Bundle
import android.view.View
import android.widget.TextView
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


        var textViewAct = findViewById<TextView>(R.id.textView)
        textViewAct.text = buildString {
        append("text Changed")
    }
        textViewAct.setOnClickListener {
           onClickTheText(it)
        }

    }

    private var clickCount = 0
    private fun onClickTheText(view: View) {
        val textViewAct = findViewById<TextView>(R.id.textView)
        textViewAct.text = "Text Changed once again $clickCount"
        clickCount++
    }
     fun resetCounter(view: View){
        clickCount = 0
         val textViewAct = findViewById<TextView>(R.id.textView)
         textViewAct.text = "Text Changed"
    }



}

