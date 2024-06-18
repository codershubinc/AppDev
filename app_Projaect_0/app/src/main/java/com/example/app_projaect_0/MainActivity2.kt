package com.example.app_projaect_0

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children


class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    // array of links on image
    private var imageUrlLinkList = arrayOf(
        "https://www.clipartbest.com/cliparts/xig/Kyq/xigKyqA5T.png",
        "https://www.clipartbest.com/cliparts/9cz/LKX/9czLKXBcE.png",
        "https://www.clipartbest.com/cliparts/yTk/7aG/yTk7aGETE.png",
        "https://www.clipartbest.com/cliparts/yco/7aG/yco7aG7cE.jpeg",
        "https://www.clipartbest.com/cliparts/dT7/LKL/dT7LKLpXc.jpg",
        "https://www.clipartbest.com/cliparts/jcx/LKL/jcxLKLAMi.jpg",
        "https://www.clipartbest.com/cliparts/9cz/LKL/9czLKLpgi.jpg",
        "https://www.clipartbest.com/cliparts/RiA/EeE/RiAEeEEdT.jpg",
        "https://www.clipartbest.com/cliparts/xig/LeL/xigLeLbyT.jpg",
        "https://www.clipartbest.com/cliparts/aie/RqK/aieRqKMxT.jpeg",
        "https://www.clipartbest.com/cliparts/9Tp/6rx/9Tp6rxbrc.jpg"
    )


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

 val myTextView = findViewById<TextView>(R.id.textView3)
        myTextView.text = imageUrlLinkList[0]

        
    }
}