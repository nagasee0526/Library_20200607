package com.ubis.library_20200607

import androidx.appcompat.app.AppCompatActivity

abstract class baseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setValues()
    abstract fun setEvents()
}