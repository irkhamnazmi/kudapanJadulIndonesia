package com.example.kudapanjadul

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailSnackActivity : AppCompatActivity(), View.OnClickListener {
         var sharelink: String =""
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DIST_AREA = "extra_dist_area"
        const val EXTRA_LINK = "extra_link"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_snack)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDistArea: TextView = findViewById(R.id.tv_item_dist_area)
        val tvLink: TextView = findViewById(R.id.tv_item_link)
        val tvDetail: TextView = findViewById(R.id.tv_item_detail)
        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val icWhatsApp: ImageView = findViewById(R.id.img_whatsapp)
        val icInstagram: ImageView = findViewById(R.id.img_instagram)
        val icFacebook: ImageView = findViewById(R.id.img_facebook)
        val icGmail: ImageView = findViewById(R.id.img_gmail)

        val tvSubtitle: TextView = findViewById(R.id.tv_item_subtitle)

        icWhatsApp.setOnClickListener(this)
        icInstagram.setOnClickListener(this)
        icFacebook.setOnClickListener(this)
        icGmail.setOnClickListener(this)


        val name = intent.getStringExtra(EXTRA_NAME)
        val distArea = intent.getStringExtra(EXTRA_DIST_AREA)
        val link = intent.getStringExtra(EXTRA_LINK)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val photo = intent.getIntExtra(EXTRA_PHOTO,0)

        tvName.text = name
        tvDistArea.text = distArea
        tvLink.text = link
        tvDetail.text = "\t \t"+detail
        tvSubtitle.text = "Tentang "+name

        Glide.with(this)
            .load(photo)
            .into(imgPhoto)

        Glide.with(this)
            .load(R.drawable.ic_whatsapp)
            .into(icWhatsApp)

        Glide.with(this)
            .load(R.drawable.ic_instagram)
            .into(icInstagram)

        Glide.with(this)
            .load(R.drawable.ic_facebook)
            .into(icFacebook)

        Glide.with(this)
            .load(R.drawable.ic_gmail)
            .into(icGmail)

        supportActionBar?.title = "Detail Kudapan"
        sharelink = tvLink.text.toString()
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.img_whatsapp ->{
               val whatsAppIntent = Intent(Intent.ACTION_SEND)
               whatsAppIntent.type = "text/plain"
               whatsAppIntent.setPackage("com.whatsapp")
               whatsAppIntent.putExtra(Intent.EXTRA_TEXT, sharelink)
               if(whatsAppIntent.resolveActivity(packageManager)==null){
                   Toast.makeText(this, "WhatsApp belum tersedia di perangkat ini", Toast.LENGTH_SHORT).show()
                   return
               }
               startActivity(whatsAppIntent)
           }
           R.id.img_instagram ->{
               val instagramIntent = Intent(Intent.ACTION_SEND)
               instagramIntent.type = "text/plain"
               instagramIntent.setPackage("com.instagram.android")
               instagramIntent.putExtra(Intent.EXTRA_TEXT, sharelink)
               if(instagramIntent.resolveActivity(packageManager)==null){
                   Toast.makeText(this, "Instagram belum tersedia di perangkat ini", Toast.LENGTH_SHORT).show()
                   return
               }
               startActivity(instagramIntent)
           }
           R.id.img_facebook->{
               val facebookIntent = Intent(Intent.ACTION_SEND)
               facebookIntent.type = "text/plain"
               facebookIntent.setPackage("com.facebook.katana")
               facebookIntent.putExtra(Intent.EXTRA_TEXT,sharelink)
               if (facebookIntent.resolveActivity(packageManager)==null){
                   Toast.makeText(this, "Facebook belum tersedia di perangkat ini", Toast.LENGTH_SHORT).show()
                   return
               }
               startActivity(facebookIntent)
           }
           R.id.img_gmail->{
               val gmailIntent = Intent(Intent.ACTION_SEND)
               gmailIntent.type = "text/plain"
               gmailIntent.setPackage("com.google.android.gm")
               gmailIntent.putExtra(Intent.EXTRA_TEXT,sharelink)
               if(gmailIntent.resolveActivity(packageManager)==null){
                   Toast.makeText(this, "Gmail belum tersedia di perangkat ini", Toast.LENGTH_SHORT).show()
                   return
               }
               startActivity(gmailIntent)
           }

       }
    }


}