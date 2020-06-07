package com.ubis.library_20200607

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : baseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEvents()
        setValues()
    }

    override fun setValues() {
    }

    override fun setEvents() {
        profileiu.setOnClickListener {
            val myIntent = Intent(mContext, ViewProfileActivity::class.java)
            startActivity(myIntent)
        }
    }
}
