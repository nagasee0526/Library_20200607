package com.ubis.library_20200607

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : baseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEvents()
        setValues()
    }

    override fun setValues() {
        Glide.with(mContext).load("https://news.kbs.co.kr/data/news/2019/01/16/4117160_uS4.jpg").into(profileiu)
    }

    override fun setEvents() {
        profileiu.setOnClickListener {
            val myIntent = Intent(mContext, ViewProfileActivity::class.java)
            startActivity(myIntent)
        }

        collBtn.setOnClickListener {
            val MyUrl = Uri.parse("tel:${PhonenumTxt.text}")
            val myIntent = Intent(Intent.ACTION_CALL, MyUrl)
            startActivity(myIntent)
        }
    }
}
