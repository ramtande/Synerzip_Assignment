package com.synerzip.assigment.ui

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.synerzip.assigment.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            initializeNewsFragment()
        }

    }

    private fun initializeNewsFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, NewsFragment())
        transaction.commit()
    }
}
