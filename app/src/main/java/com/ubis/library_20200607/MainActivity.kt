package com.ubis.library_20200607

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
    }
}
