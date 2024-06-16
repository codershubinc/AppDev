package com.example.app_projaect_0

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Placeholder
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {
    // private  var imageUrlLinkList  ;
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


    private var clickCount = 0
    private var currentImageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textViewAct = findViewById<TextView>(R.id.textView)
        textViewAct.text = buildString {
            append("text Changed")
        }

        // Click listener for the textView
        textViewAct.setOnClickListener {
            onClickTheText()
        }
        val imageView = findViewById<ImageView>(R.id.imageView)
        loadSvgImage(
            imageView,
            imageUrlLinkList[0],
            findViewById(R.id.progressBar)
        )

    }

    private fun onClickTheText() {
        val textViewAct = findViewById<TextView>(R.id.textView)
        if (clickCount == 20) {
            val textViewAct1 = findViewById<TextView>(R.id.textView2)
            textViewAct1.text = "Too Many Clicks"
            return
        }

        textViewAct.text = "Text Changed once again count $clickCount"
        clickCount++


    }

    fun resetCounter(view: View) {
        clickCount = 0
        val textViewAct = findViewById<TextView>(R.id.textView)
        textViewAct.text = "Text Changed count set to count 0"
    }

    /*
        private fun loadSvgImage(imageView: ImageView, url: String) {
            val imageLoader = ImageLoader.Builder(applicationContext)
                .components {
                    add(SvgDecoder.Factory())
                }
                .build()

            val request = ImageRequest.Builder(applicationContext)
                .data(url)
                .target(imageView)
                .build()


            imageLoader.enqueue(request)
        }
      */
    private fun loadSvgImage(imageView: ImageView, url: String, progressBar: ProgressBar) {
        val imageLoader = ImageLoader.Builder(applicationContext)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()

        val request = ImageRequest.Builder(applicationContext)
            .data(url)
            .target(
                onStart = {
                    progressBar.visibility = View.VISIBLE
                },
                onSuccess = { result ->
                    imageView.setImageDrawable(result)
                    progressBar.visibility = View.GONE
                },
                onError = {
                    // Handle the error case
                    progressBar.visibility = View.GONE
                }
            )
            .build()

        imageLoader.enqueue(request)
    }

    fun nextImage(view: View) {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (currentImageIndex === imageUrlLinkList.size - 1) {
            currentImageIndex = 0
        }
        currentImageIndex++
        loadSvgImage(
            imageView,
            imageUrlLinkList[currentImageIndex],
            findViewById(R.id.progressBar)
        )

    }

    fun prevImage(view: View) {
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (currentImageIndex === 0) {
            currentImageIndex = imageUrlLinkList.size - 1
        }
        currentImageIndex--
        loadSvgImage(
            imageView,
            imageUrlLinkList[currentImageIndex],
            findViewById(R.id.progressBar)
        )
    }

    // open anather intent
    fun openAnatherIntent(view: View) {
   //     val intent = Intent(this, MainActivity2::class.java)
    //    startActivity(intent)
    }
}
