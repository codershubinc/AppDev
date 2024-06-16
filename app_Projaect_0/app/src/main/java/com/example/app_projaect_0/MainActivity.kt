package com.example.app_projaect_0

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load

@SuppressLint("SetTextI18n")

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

        val imView = findViewById<ImageView>(R.id.imageView)
        imView.load(
            "https://tse3.mm.bing.net/th?q=Load+Image+from+URL+in+Android+Using+Glide+Library&pid=Api&mkt=en-IN&cc=IN&setlang=en&adlt=moderate&t=3"
        )
        val textViewAct = findViewById<TextView>(R.id.textView)
        textViewAct.text = buildString {
            append("text Changed")
        }
        textViewAct.setOnClickListener {
            onClickTheText()
        }


    }

    private var clickCount = 0


    private fun onClickTheText() {
        val textViewAct = findViewById<TextView>(R.id.textView)
        if (clickCount == 20) {
            textViewAct.text = "To Many Clicks "
        }

        textViewAct.text = "Text Changed once again $clickCount"
        clickCount++
    }

    fun resetCounter(view: View) {
        clickCount = 0
        val textViewAct = findViewById<TextView>(R.id.textView)
        textViewAct.text = "Text Changed"
    }


}

