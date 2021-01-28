package com.example.kudapanjadul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {
    private lateinit var imgAboutMe:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        imgAboutMe = findViewById(R.id.img_about_me)

        Glide.with(this)
            .load(R.drawable.aboutme)
            .apply(RequestOptions().override(150,150))
            .into(imgAboutMe)

        supportActionBar?.title = "Tentang Saya"
    }
}